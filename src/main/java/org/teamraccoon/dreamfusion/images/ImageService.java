package org.teamraccoon.dreamfusion.images;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.MessageFormat;

import javax.management.RuntimeErrorException;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.teamraccoon.dreamfusion.products.Product;
import org.teamraccoon.dreamfusion.products.ProductNotFoundException;
import org.teamraccoon.dreamfusion.products.ProductRepository;
import org.teamraccoon.dreamfusion.utilities.Time;

@Service
public class ImageService {

    ImageRepository imageRepository;
    ProductRepository productRepository;
    Time time;
    private final String uploadDir = "src/main/resources/static/images/";

    public ImageService(ImageRepository imageRepository, ProductRepository productRepository, Time time) {
        this.imageRepository = imageRepository;
        this.productRepository = productRepository;
        this.time = time;
    }

    public String save(@NonNull Long productId, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String baseName = fileName.substring(0, fileName.lastIndexOf("."));
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        String combinedName = MessageFormat.format("{0}-{1}.{2}", baseName, time.checkCurrentTime(), fileExtension);
        Path path = Paths.get(uploadDir, combinedName);

        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        Image newImage = Image.builder()
            .imageName(combinedName)
            .product(product)
            .build();

        try (InputStream inputStream = file.getInputStream()) {
            if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file.");
			}
            if (combinedName.contains("MainImage")) {
                newImage.setMainImage(true);
            }
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
            imageRepository.save(newImage);
        } catch (IOException e) {
            throw new RuntimeErrorException(null, "File" + combinedName + "has not been saved");
        }

        return combinedName;
    }

    public Image markImageAsMain(Image image) {
        image.setMainImage(true);
        return image;
    }
}