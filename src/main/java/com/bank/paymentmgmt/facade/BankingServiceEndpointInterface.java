package com.bank.paymentmgmt.facade;

import jakarta.jws.*;

@WebService(name="BankingEndpoint")
public interface BankingServiceEndpointInterface {

    @WebMethod(operationName = "paymentOperation")
    @WebResult(name="acceptedPayment")
    Boolean createPayment(@WebParam(name = "cardNumber")String ccNumber, @WebParam(name = "amountPaid") Double amount);

}
