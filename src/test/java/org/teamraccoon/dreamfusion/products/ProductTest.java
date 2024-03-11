package org.teamraccoon.dreamfusion.products;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {

    Product product;

    @BeforeEach
    void setUp() {
        
        product = new Product(1L, "Superman", "Una figura de Superman en 3D", "/superman.jpg", 12L);
    }

    @Test
    void testProductHas5Attributes() {
        Field[] fields = product.getClass().getDeclaredFields();
        assertThat(fields.length, is(5));
    }

    @Test
    void testProductHaveIdProductnamePasswordProfile() {
        assertThat(product.getId(), is(1L));
        assertThat(product.getProductName(), is("Superman"));
        assertThat(product.getDescription(), is("Una figura de Superman en 3D"));
        assertThat(product.getProductImage(), is("/superman.jpg"));
        assertThat(product.getPrice(), is(12L));
    }
}