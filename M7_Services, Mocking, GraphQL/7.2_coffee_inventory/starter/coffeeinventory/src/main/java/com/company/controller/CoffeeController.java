package com.company.controller;

import com.company.service.ServiceLayer;
import com.company.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/coffees")
public class CoffeeController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    public Coffee createCoffee(@RequestBody Coffee coffee) {
        return serviceLayer.saveCoffee(coffee);
    }

    @GetMapping
    public List<Coffee> getAllCoffees() {
        return serviceLayer.findAllCoffees();
    }

    @GetMapping(value = "/{id}")
    public Coffee getCoffeeById(@PathVariable int id) {
        return serviceLayer.findCoffee(id);
    }

    @PutMapping(value = "/{id}")
    public void updateCoffee(@RequestBody Coffee coffee, @PathVariable int id) {
        serviceLayer.updateCoffee(coffee);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCoffee(@PathVariable int id) {
        serviceLayer.removeCoffee(id);
    }

}
