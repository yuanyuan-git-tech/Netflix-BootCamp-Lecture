package com.company.service;

import com.company.repository.CoffeeRepository;
import com.company.repository.RoasterRepository;
import com.company.model.Coffee;
import com.company.model.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {

    private CoffeeRepository coffeeRepository;
    private RoasterRepository roasterRepository;

    @Autowired
    public ServiceLayer(CoffeeRepository coffeeRepository, RoasterRepository roasterRepository) {
        this.coffeeRepository = coffeeRepository;
        this.roasterRepository = roasterRepository;
    }

    //
    // Coffee API
    //

    public Coffee saveCoffee(Coffee coffee) {

        return coffeeRepository.save(coffee);
    }

    public Coffee findCoffee(int id) {

        Optional<Coffee> coffee = coffeeRepository.findById(id);
        return coffee.isPresent() ? coffee.get() : null;
    }

    public List<Coffee> findAllCoffees() {

        return coffeeRepository.findAll();
    }

    public void updateCoffee(Coffee coffee) {

        coffeeRepository.save(coffee);
    }

    public void removeCoffee(int id) {

        coffeeRepository.deleteById(id);
    }

    //
    // Roaster API
    //

    public Roaster saveRoaster(Roaster roaster) {

        return roasterRepository.save(roaster);
    }

    public Roaster findRoaster(int id) {

        Optional<Roaster> roaster = roasterRepository.findById(id);
        return roaster.isPresent() ? roaster.get() : null;
    }

    public List<Roaster> findAllRoasters() {

        return roasterRepository.findAll();
    }

    public void updateRoaster(Roaster roaster) {

        roasterRepository.save(roaster);
    }

    public void removeRoaster(int id) {

        roasterRepository.deleteById(id);
    }
}
