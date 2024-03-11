package org.teamraccoon.dreamfusion.products;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.generics.IGenericFullService;
import org.teamraccoon.dreamfusion.messages.Message;

@Service
public class ProductService implements IGenericFullService<Product, ProductDTO> {

    ProductRepository repository;
    
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        List<Product> countries = repository.findAll();
        return countries;
    }

    @Override
    public Product getById(@NonNull Long id) throws Exception {
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        return product;
    }

    @Override
    public Product getByName(String name) throws Exception {
        Product product = repository.findByProductName(name).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        return product;
    }

    @Override
    public Product save(@NonNull ProductDTO product) {
        
        Product newProduct = Product.builder()
            .productName(product.productName)
            .description(product.description)
            .productImage(product.image)
            .price(product.price)
            .build();

        repository.save(newProduct);

        return newProduct;
    }

    @Override
    public Product update(@NonNull Long id, ProductDTO product) throws Exception {
        
        Product updatingProduct = repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        
        updatingProduct.setProductName(product.productName);
        updatingProduct.setDescription(product.description);
        updatingProduct.setProductImage(product.image);
        updatingProduct.setPrice(product.price);

        Product updatedProduct = repository.save(updatingProduct);
        
        return updatedProduct;
    }

    @Override
    public Message delete(@NonNull Long id) throws Exception {
        
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        String productName = product.getProductName();

        repository.delete(product);

        Message message = new Message();

        message.createMessage("Product with the name " + productName + " is deleted from the products table");

        return message;
    }
    
}