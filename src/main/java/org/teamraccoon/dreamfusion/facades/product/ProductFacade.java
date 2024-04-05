package org.teamraccoon.dreamfusion.facades.product;

import org.springframework.stereotype.Component;
import org.teamraccoon.dreamfusion.generic.IProductFacade;

@Component
public class ProductFacade implements IProductFacade{

    ImageDelete imageDelete;
    ProductDelete productDelete;

    public ProductFacade(ImageDelete imageDelete, ProductDelete productDelete) {
        this.imageDelete = imageDelete;
        this.productDelete = productDelete;
    }

    @Override
    public String delete(String type, Long id) {

        String response = "";

        if (type == "image") response = imageDelete.delete(id);
        if (type == "product") response = productDelete.delete(id);

        return response;
    }
    
}
