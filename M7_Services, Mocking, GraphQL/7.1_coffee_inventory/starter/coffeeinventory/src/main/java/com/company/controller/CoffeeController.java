package com.company.controller;

import com.company.repository.CoffeeRepository;
import com.company.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/coffees")
public class CoffeeController {

    @Autowired
    private CoffeeRepository coffeeRepo;

    @PostMapping
    public Coffee createCoffee(@RequestBody Coffee coffee) {
        coffeeRepo.save(coffee);
        return coffee;
    }

    @GetMapping
    public List<Coffee> getAllCoffees() {
        return coffeeRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Coffee getCoffeeById(@PathVariable int id) {
        Optional<Coffee> coffee = coffeeRepo.findById(id);

        if (!coffee.isPresent()) {
            return null;
        }

        return coffee.get();
    }

    @PutMapping(value = "/{id}")
    public void updateCoffee(@RequestBody Coffee coffee, @PathVariable int id) {
        if(coffee.getId() == null) {
            coffee.setId(id);
        }

        if(coffee.getId() != id) {
            throw new IllegalArgumentException("Coffee ID must match parameter given");
        }
        coffeeRepo.save(coffee);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCoffee(@PathVariable int id) {
        coffeeRepo.deleteById(id);
    }

}
