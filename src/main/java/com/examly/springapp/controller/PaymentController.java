package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/{id}")
    public String getPaymentController(@PathVariable Long id)
    {
        return "Payment ID: " + id;
    }
    
}
