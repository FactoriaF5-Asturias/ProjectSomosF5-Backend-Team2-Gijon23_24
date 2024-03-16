package org.teamraccoon.dreamfusion.images;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.teamraccoon.dreamfusion.messages.ResponseMessage;

@RestController
@RequestMapping(path = "${api-endpoint}")
public class ImageController {

    @Autowired
    private ImageService service;

    @PostMapping(path = "/images/uploadMainImage/{id}")
    ResponseEntity<String> uploadMainImage(@PathVariable("id") @NonNull Long id, @RequestParam("image") MultipartFile mainImage) {

        service.saveMainImage(id, mainImage);

        return ResponseEntity.status(201).body("File with the name " + mainImage.getOriginalFilename() + " is successfully uploaded");
    }

    @PostMapping(path = "/images/uploadImages")
    ResponseEntity<ResponseMessage> uploadImages(@RequestParam("images") MultipartFile[] images) {

        String message = "";

        try {
            List<String> fileNames = new ArrayList<>();

            Arrays.asList(images).stream().forEach(file -> {
                // service.save(file);
                fileNames.add(file.getOriginalFilename());
            });

            message = "File with the names '" + fileNames + "' are uploaded successfully: ";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
}