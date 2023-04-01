package com.example.utilityapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    public CalculatorController() {
    }

    @RequestMapping(value = "/calculator/divide", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public double divide(@RequestParam int value1, @RequestParam int value2) {

        if (value2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }

        return (double)value1 / value2;
    }

    @RequestMapping(value = "/calculator/isperfectsquare/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public boolean isperfectsquare(@PathVariable int value) {

        return false;
    }

    @RequestMapping(value = "/calculator/factorial/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int factorial(@PathVariable int value) {

        return 0;
    }
}
