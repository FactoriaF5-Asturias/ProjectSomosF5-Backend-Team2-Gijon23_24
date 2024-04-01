package org.teamraccoon.dreamfusion.payments;

import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.config.payments.stripe.StripeConfiguration;
import org.teamraccoon.dreamfusion.facades.payments.PaymentFacade;

import com.stripe.exception.StripeException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentService {

    StripeConfiguration stripeConfig;
    PaymentFacade paymentFacade;

    public PaymentResponse createPaymentIntent(String paymentProvider, PaymentRequest payment) throws StripeException {

        PaymentResponse response = paymentFacade.createPaymentIntent("stripe", payment);

        return response;
    }
}
