package org.teamraccoon.dreamfusion.facades.product;

import org.springframework.stereotype.Component;
import org.teamraccoon.dreamfusion.generic.IDelete;
import org.teamraccoon.dreamfusion.products.Product;
import org.teamraccoon.dreamfusion.products.ProductNotFoundException;
import org.teamraccoon.dreamfusion.products.ProductRepository;

@Component
public class ProductDelete implements IDelete {

    ProductRepository productRepository;

    public ProductDelete(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String delete(Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        String productName = product.getProductName();

        productRepository.delete(product);

        return "Product '" + productName +  "' is deleted successfully.";
    }
}
