package com.stackroute.stripepayment.service;

import com.stripe.model.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Refund;
@Component
public class PaymentService {


    @Autowired
    PaymentService() {
        //Stripe.apiKey = "sk_test_vPdUFvDpA4y3GzNpQqGitpiz";
        Stripe.apiKey = "sk_test_5AEV0g0dMzEsD7XRUqQ8o1jw";
    }

    String chargeId;


    public Charge chargeNewCard(String token, double amount) throws Exception {
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", (int) (amount * 100));
        chargeParams.put("currency", "INR");
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);
        chargeId = charge.getId();
        System.out.println(charge.getId());
        return charge;
    }


    public Refund cardRefund() throws Exception {
        Map<String, Object> refundParams = new HashMap<String, Object>();
        refundParams.put("charge", chargeId);

        Refund refund = Refund.create(refundParams);
        return refund;

    }

    public Customer createCustomer(String token, String email) throws Exception {
        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("email", email);
        customerParams.put("source", token);
        return Customer.create(customerParams);
    }

    public Charge chargeCustomerCard(String customerId, int amount) throws Exception {
        String sourceCard =     Customer.retrieve(customerId).getDefaultSource();
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", amount);
        chargeParams.put("currency", "USD");
        chargeParams.put("customer", customerId);
        chargeParams.put("source", sourceCard);
        Charge charge = Charge.create(chargeParams);
        return charge;
    }
}

