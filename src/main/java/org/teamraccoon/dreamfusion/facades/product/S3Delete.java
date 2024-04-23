package org.teamraccoon.dreamfusion.facades.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.teamraccoon.dreamfusion.config.AWSConfiguration;
import org.teamraccoon.dreamfusion.generic.IDelete;
import org.teamraccoon.dreamfusion.images.Image;
import org.teamraccoon.dreamfusion.images.ImageRepository;
import org.teamraccoon.dreamfusion.products.Product;
import org.teamraccoon.dreamfusion.products.ProductNotFoundException;
import org.teamraccoon.dreamfusion.products.ProductRepository;

import software.amazon.awssdk.services.s3.model.Delete;
import software.amazon.awssdk.services.s3.model.DeleteObjectsRequest;
import software.amazon.awssdk.services.s3.model.ObjectIdentifier;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Component
public class S3Delete implements IDelete {

    ProductRepository productRepository;
    ImageRepository imageRepository;
    AWSConfiguration config;

    public S3Delete(ProductRepository productRepository, ImageRepository imageRepository, AWSConfiguration config) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
        this.config = config;
    }

    @Override
    public String delete(Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        String filename = new String();
        List<ObjectIdentifier> filenames = new ArrayList<>();

        String bucketName = config.getAwsBucket();

        if (product.getImages() != null) {
            for (Image image : product.getImages()) {
                filename = image.getImageName();
                ObjectIdentifier objectId = ObjectIdentifier.builder()
                    .key(filename)
                    .build();
                filenames.add(objectId);
            }

            Delete del = Delete.builder()
                .objects(filenames)
                .build();

            try {
                DeleteObjectsRequest multiObjectDeleteRequest = DeleteObjectsRequest.builder()
                        .bucket(bucketName)
                        .delete(del)
                        .build();
    
                config.createS3Client().deleteObjects(multiObjectDeleteRequest);
                System.out.println("Multiple objects are deleted!");
    
            } catch (S3Exception e) {
                System.err.println(e.awsErrorDetails().errorMessage());
                System.exit(1);
            }
        }

        return "Images with names '" + filenames +  "' are deleted successfully";
    }
}
