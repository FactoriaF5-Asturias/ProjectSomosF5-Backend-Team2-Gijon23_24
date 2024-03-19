package org.teamraccoon.dreamfusion.products;

import lombok.Builder;

@Builder
public class ProductDTO {
    public String productName;
    public String productDescription;
    public float price;
    public Long categoryId;
}