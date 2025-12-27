package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @GetMapping("/{id}")
    public String getMembershipController(@PathVariable Long id)
    {
        return "Membership ID: "+ id;
    }
    
}
