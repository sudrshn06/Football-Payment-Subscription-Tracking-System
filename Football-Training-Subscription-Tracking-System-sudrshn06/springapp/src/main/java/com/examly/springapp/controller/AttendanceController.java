package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/attendance")

public class AttendanceController {
    @GetMapping("/{id}")
    public String getAttendanceById(@PathVariable Long id)
    {
        return "Attendance ID: "+id;
    }
    
}
