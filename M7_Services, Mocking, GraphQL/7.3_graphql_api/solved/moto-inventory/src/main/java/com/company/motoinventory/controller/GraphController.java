package com.company.motoinventory.controller;

import com.company.motoinventory.models.Motorcycle;
import com.company.motoinventory.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphController {

    @Autowired
    MotorcycleRepository motorcycleRepository;

    @QueryMapping
    public List<Motorcycle> motorcycles() {
        return  motorcycleRepository.getMotorcycles();
    }

    @QueryMapping
    public Motorcycle findMotorcycleById(@Argument String id) {
        return motorcycleRepository.getMotorcycleById(id);
    }

    @MutationMapping
    public Motorcycle addMotorcycle(
            @Argument String id,
            @Argument String make,
            @Argument String model,
            @Argument int year) {
        return motorcycleRepository.addMotorcycle(id, make, model, year);
    }

    @MutationMapping
    public Motorcycle updateMotorcycle(
            @Argument String id,
            @Argument String make,
            @Argument String model,
            @Argument int year) {
        Motorcycle updatedMotorcycle = new Motorcycle(id, make, model, year);
        return motorcycleRepository.updateMotorcycle(updatedMotorcycle);
    }

    @MutationMapping
    public boolean deleteMotorcycleById(@Argument String id) {
        return motorcycleRepository.deleteMotorcycleById(id);
    }
}
