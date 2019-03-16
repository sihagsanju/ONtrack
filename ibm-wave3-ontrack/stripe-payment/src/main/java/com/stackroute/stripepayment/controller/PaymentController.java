package com.stackroute.stripepayment.controller;

import com.stackroute.stripepayment.service.PaymentService;
import com.stripe.model.Charge;
import com.stripe.model.Refund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

//import org.apache.catalina.servlet4preview.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("payment")
public class PaymentController {

    PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/charge")
    public Charge chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        Double amount = Double.parseDouble(request.getHeader("amount"));
        return this.paymentService.chargeNewCard(token, amount);
    }

    /**
     * Refund a charge via the API, perform a cardRefund call, providing the ID
     * of the charge to be refunded.
     **/
    @PostMapping("/refund")
    public Refund refundCard(HttpServletRequest request) throws Exception {
        return this.paymentService.cardRefund();
    }
}