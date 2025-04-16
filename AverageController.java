package com.example.averagecalculator.controller;

import com.example.averagecalculator.model.ResponseModel;
import com.example.averagecalculator.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numbers")
public class AverageController {

    @Autowired
    private NumberService numberService;

    @GetMapping("/{numberId}")
    public ResponseModel getNumbers(@PathVariable String numberId) {
        return numberService.handleRequest(numberId);
    }
}
