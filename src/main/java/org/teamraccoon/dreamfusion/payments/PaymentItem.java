package org.teamraccoon.dreamfusion.payments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentItem {
    
    private Long id;
    private String productName;
    private Long price;
}