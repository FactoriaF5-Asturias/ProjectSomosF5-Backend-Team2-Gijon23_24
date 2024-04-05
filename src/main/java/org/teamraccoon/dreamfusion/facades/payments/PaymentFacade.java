package org.teamraccoon.dreamfusion.facades.payments;

import org.springframework.stereotype.Component;
import org.teamraccoon.dreamfusion.payments.PaymentRequest;
import org.teamraccoon.dreamfusion.payments.PaymentResponse;

import com.stripe.exception.StripeException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PaymentFacade implements IPaymentFacade<PaymentResponse> {

    StripePayment stripePayment;

    public PaymentResponse createPaymentIntent(String type, PaymentRequest payment) throws StripeException {

        PaymentResponse response = new PaymentResponse();

        if (type == "stripe") response = stripePayment.createPaymentIntent(payment);

        return response;
    }
}
