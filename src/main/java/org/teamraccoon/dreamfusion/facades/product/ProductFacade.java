package org.teamraccoon.dreamfusion.facades.product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.teamraccoon.dreamfusion.config.StorageProperties;
import org.teamraccoon.dreamfusion.generic.IDeleteProductFacade;
import org.teamraccoon.dreamfusion.images.Image;
import org.teamraccoon.dreamfusion.images.ImageRepository;
import org.teamraccoon.dreamfusion.products.Product;
import org.teamraccoon.dreamfusion.products.ProductNotFoundException;
import org.teamraccoon.dreamfusion.products.ProductRepository;

@Component
public class ProductFacade implements IDeleteProductFacade{

    ProductRepository productRepository;
    ImageRepository imageRepository;
    private final Path rootLocation;

    public ProductFacade(ProductRepository productRepository, ImageRepository imageRepository, StorageProperties properties) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
        this.rootLocation = Paths.get(properties.getLocation());
    }



    @Override
    public String delete(Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        if (product.getImages() != null) {
            for (Image image : product.getImages()) {
                try {
                    Path file = rootLocation.resolve(image.getImageName());
                    Files.deleteIfExists(file);
                } catch (IOException e) {
                    throw new RuntimeException("Error: " + e.getMessage());
                }
            }
        }

        String productName = product.getProductName();

        productRepository.delete(product);

        return "Product '" + productName +  "' and corresponging files are deleted successfully";
    }
    
}
