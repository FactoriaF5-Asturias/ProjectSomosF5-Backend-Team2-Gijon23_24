package org.teamraccoon.dreamfusion.facades.payments;

import org.teamraccoon.dreamfusion.payments.PaymentRequest;

public interface IPayment<T> {
    T createPaymentIntent(PaymentRequest request) throws Exception;
}
