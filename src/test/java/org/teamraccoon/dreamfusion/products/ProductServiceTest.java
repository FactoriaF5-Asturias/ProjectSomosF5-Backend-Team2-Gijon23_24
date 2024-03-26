package org.teamraccoon.dreamfusion.products;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.teamraccoon.dreamfusion.categories.CategoryRepository;
import org.teamraccoon.dreamfusion.facades.product.ProductFacade;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    ProductService service;

    @Mock
    ProductRepository repository;

    @Mock
    CategoryRepository categoryRepository;

    @Mock
    ProductFacade productFacade;

    @BeforeEach
    void setUp() {
        this.service = new ProductService(repository, categoryRepository, productFacade);
    }

    @Test
    void testGetAllProducts() {
        Product goku = Product.builder().productName("Goku").id(1L).build();
        Product bulma = Product.builder().productName("Bulma").id(2L).build();

        List<Product> products = new ArrayList<>();
        products.add(goku);
        products.add(bulma);

        when(repository.findAll()).thenReturn(products);
        List<Product> result = service.getAll();

        assertThat(result, contains(goku, bulma));

    }

    @Test
    void testShouldReturnProductById() throws Exception {
        Product goku = Product.builder().productName("Goku").id(1L).build();
        
        when(repository.findById(1L)).thenReturn(Optional.of(goku));
        Product product = service.getById(1L);

        assertThat(product, is(goku));
    }

    @Test
    void testShouldReturnProductByName() throws Exception {
        Product goku = Product.builder().productName("Goku").id(1L).build();
        
        when(repository.findByProductName("Goku")).thenReturn(Optional.of(goku));
        Product product = service.getByName("Goku");

        assertThat(product, is(goku));
    }

    @Test
    void testShouldReturnProductNotFound() {
        
        when(repository.findById(1L)).thenThrow(new ProductException("Product not found"));
        ProductException exception = assertThrows(ProductException.class, () -> service.getById(1L));

        String actualMessage = exception.getMessage();
        String expectedMessage = "Product not found";

        assertThat(actualMessage, is(expectedMessage));
        assertThat(actualMessage.contains(expectedMessage), is(true));

    }

}