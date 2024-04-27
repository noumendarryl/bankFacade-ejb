package com.bank.paymentmgmt.server;

import com.bank.paymentmgmt.facade.BankingServiceBean;
import jakarta.xml.ws.Endpoint;

public class BankingServer {

    public static void main(String[] args) {
        String url = "http://0.0.0.0:11080/BankingService/BankingServiceBean";
        Endpoint.publish(url, new BankingServiceBean());
        System.out.println("EJB Endpoint deployed bankFacade-ejb listening at address at " + url);
    }

}
