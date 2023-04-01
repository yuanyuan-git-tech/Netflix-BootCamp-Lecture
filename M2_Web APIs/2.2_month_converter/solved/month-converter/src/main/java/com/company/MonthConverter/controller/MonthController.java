package com.company.MonthConverter.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MonthController {
    @RequestMapping(value="/month/{monthNumber}", method=RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String getMonth(@PathVariable String monthNumber) {

        switch (monthNumber) {
            case "1":
                return "January";
            case "2":
                return "February";
            case "3":
                return "March";
            case "4":
                return "April";
            case "5":
                return "May";
            case "6":
                return "June";
            case "7":
                return "July";
            case "8":
                return "August";
            case "9":
                return "September";
            case "10":
                return "October";
            case "11":
                return "November";
            case "12":
                return "December";
            default:
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Month Number Specified");
        }
    }
}
