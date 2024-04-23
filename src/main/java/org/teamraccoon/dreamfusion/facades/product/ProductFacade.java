package org.teamraccoon.dreamfusion.facades.product;

import org.springframework.stereotype.Component;
import org.teamraccoon.dreamfusion.generic.IProductFacade;

@Component
public class ProductFacade implements IProductFacade{

    ImageDelete imageDelete;
    ProductDelete productDelete;
    S3Delete s3Delete;

    public ProductFacade(ImageDelete imageDelete, ProductDelete productDelete, S3Delete s3Delete) {
        this.imageDelete = imageDelete;
        this.productDelete = productDelete;
        this.s3Delete = s3Delete;
    }

    @Override
    public String delete(String type, Long id) {

        String response = "";

        if (type == "image") response = imageDelete.delete(id);
        if (type == "imageS3") response = s3Delete.delete(id);
        if (type == "product") response = productDelete.delete(id);

        return response;
    }
    
}
