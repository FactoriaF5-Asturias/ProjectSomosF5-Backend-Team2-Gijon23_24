package org.teamraccoon.dreamfusion.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    public String productName;
    public String productDescription;
    public float price;
    public Long categoryId;
}