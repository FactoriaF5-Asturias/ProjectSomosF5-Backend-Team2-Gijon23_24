package org.teamraccoon.dreamfusion.facades.payments;

import org.springframework.stereotype.Component;
import org.teamraccoon.dreamfusion.config.payments.stripe.StripeConfiguration;
import org.teamraccoon.dreamfusion.payments.Calculator;
import org.teamraccoon.dreamfusion.payments.PaymentRequest;
import org.teamraccoon.dreamfusion.payments.PaymentResponse;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class StripePayment implements IPayment<PaymentResponse> {

    StripeConfiguration stripeConfig;

    public PaymentResponse createPaymentIntent(PaymentRequest payment) throws StripeException {

        Stripe.apiKey = stripeConfig.getSecretKey();

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(Calculator.calculateOrderAmount(payment.getItems()))
                .setCurrency("eur")
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods
                                .builder()
                                .setEnabled(true)
                                .build())
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);

        PaymentResponse paymentResponse = new PaymentResponse(paymentIntent.getClientSecret());

        return paymentResponse;
    }
}
