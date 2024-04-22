package org.teamraccoon.dreamfusion.images;

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
public class S3ImageController {

    @Autowired
    S3ImageService service;

    @PostMapping(path = "/images/uploadToS3/{id}")
    ResponseEntity<ResponseMessage> uploadImages(@PathVariable("id") @NonNull Long id,
            @RequestParam(name = "file", required = false) MultipartFile file) {

        String message = "";

        try {
            service.saveMainImage(id, file);
            message = "Files are uploaded successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }
    
}
