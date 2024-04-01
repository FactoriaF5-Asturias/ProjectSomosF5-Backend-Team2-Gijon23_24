package org.teamraccoon.dreamfusion.facades.payments;

import org.teamraccoon.dreamfusion.payments.PaymentRequest;

public interface IPaymentFacade<T> {
    T createPaymentIntent(String type, PaymentRequest request) throws Exception;
}