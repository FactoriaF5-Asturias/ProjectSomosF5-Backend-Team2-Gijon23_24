package org.teamraccoon.dreamfusion.images;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.teamraccoon.dreamfusion.config.AWSConfiguration;
import org.teamraccoon.dreamfusion.products.Product;
import org.teamraccoon.dreamfusion.products.ProductNotFoundException;
import org.teamraccoon.dreamfusion.products.ProductRepository;
import org.teamraccoon.dreamfusion.utilities.Time;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3ImageService {

    ImageRepository imageRepository;
    ProductRepository productRepository;
    Time time;
    AWSConfiguration awsConfiguration;

    public S3ImageService(ImageRepository imageRepository, ProductRepository productRepository, Time time,
            AWSConfiguration awsConfiguration) {
        this.imageRepository = imageRepository;
        this.productRepository = productRepository;
        this.time = time;
        this.awsConfiguration = awsConfiguration;
    }

    public void saveMainImage(@NonNull Long productId, MultipartFile file) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        Image searchedMainimage = product.getImages().stream().filter(image -> image.isMainImage()).findFirst()
                .orElse(null);

        if (file != null && !product.getImages().contains(searchedMainimage)) {
            String uniqueName = createUniqueName(file);

            Image newImage = Image.builder()
                    .imageName(uniqueName)
                    .isMainImage(true)
                    .product(product)
                    .build();

            try (InputStream inputStream = file.getInputStream()) {
                if (file.isEmpty()) {
                    throw new StorageException("Failed to store empty file.");
                }

                Map<String, String> metadata = createMetadata(file);

                String objectKey = uniqueName;
                String bucketName = awsConfiguration.getAwsBucket();

                PutObjectRequest putOb = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .metadata(metadata)
                    .build();

                awsConfiguration.createS3Client().putObject(putOb, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

                System.out.println("Successfully uploaded " + objectKey + " to bucket " + bucketName);
                imageRepository.save(newImage);
            } catch (IOException e) {
                throw new RuntimeErrorException(null, "File" + uniqueName + "has not been saved");
            }

        }

    }

    public String createUniqueName(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String baseName = fileName.substring(0, fileName.lastIndexOf("."));
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        String combinedName = MessageFormat.format("{0}-{1}.{2}", baseName, time.checkCurrentTime(), fileExtension);

        return combinedName;
    }

    public Map<String, String> createMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        String filesize = Long.toString(file.getSize());
        metadata.put("content-type", file.getContentType());
        metadata.put("size", filesize);
        return metadata;
    }
}
