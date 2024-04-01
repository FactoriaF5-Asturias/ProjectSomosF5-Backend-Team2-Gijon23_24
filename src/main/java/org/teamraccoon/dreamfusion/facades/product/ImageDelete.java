package org.teamraccoon.dreamfusion.facades.product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.teamraccoon.dreamfusion.config.StorageProperties;
import org.teamraccoon.dreamfusion.generic.IDelete;
import org.teamraccoon.dreamfusion.images.Image;
import org.teamraccoon.dreamfusion.images.ImageRepository;
import org.teamraccoon.dreamfusion.products.Product;
import org.teamraccoon.dreamfusion.products.ProductNotFoundException;
import org.teamraccoon.dreamfusion.products.ProductRepository;

@Component
public class ImageDelete implements IDelete {

    ProductRepository productRepository;
    ImageRepository imageRepository;
    private final Path rootLocation;

    public ImageDelete(ProductRepository productRepository, ImageRepository imageRepository, StorageProperties properties) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public String delete(Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        String filename = new String();
        List<String> filenames = new ArrayList<>();

        if (product.getImages() != null) {
            for (Image image : product.getImages()) {
                try {
                    filename = image.getImageName();
                    filenames.add(filename);
                    Path file = rootLocation.resolve(image.getImageName());
                    Files.deleteIfExists(file);
                } catch (IOException e) {
                    throw new RuntimeException("Error: " + e.getMessage());
                }
            }
        }

        return "Images with names '" + filenames +  "' are deleted successfully";
    }
}
