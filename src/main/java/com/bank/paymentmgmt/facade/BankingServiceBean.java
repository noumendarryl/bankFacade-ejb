package com.bank.paymentmgmt.facade;

import com.bank.paymentmgmt.domain.Payment;
import com.bank.paymentmgmt.integration.MapPaymentDAO;
import com.bank.paymentmgmt.integration.PaymentDAO;
import jakarta.ejb.Stateless;
import jakarta.jws.WebService;

@Stateless
@WebService(
        endpointInterface = "com.bank.paymentmgmt.facade.BankingServiceEndpointInterface",
        portName = "BankingPort",
        serviceName = "BankingService"
)
public class BankingServiceBean implements BankingServiceEndpointInterface {

    private PaymentDAO paymentDAO;

    public BankingServiceBean() {
        this.paymentDAO = new MapPaymentDAO();
    }

    @Override
    public Boolean createPayment(String ccNumber, Double amount) {
        if (ccNumber.length() == 10 ) {
            System.out.println("Montant payé : "+ amount +" €");
            Payment p = new Payment();
            p.setCcNumber(ccNumber);
            p.setAmount(amount);
            // pour l’instant le retour n’est pas utilisé
            p = paymentDAO.add(p);
            // juste pour tester
            paymentDAO.getAllStoredPayments();
            return true;
        } else {
            return false;
        }
    }

}
