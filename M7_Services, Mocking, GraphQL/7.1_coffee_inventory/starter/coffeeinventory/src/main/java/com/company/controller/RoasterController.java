package com.company.controller;

import com.company.repository.RoasterRepository;
import com.company.model.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/roasters")
public class RoasterController {

    @Autowired
    private RoasterRepository roasterRepo;

    @PostMapping
    public Roaster createRoaster(@RequestBody Roaster roaster) {
        roasterRepo.save(roaster);
        return roaster;
    }

    @GetMapping
    public List<Roaster> getAllRoasters() {
        return roasterRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Roaster getRoasterById(@PathVariable int id) {
        Optional<Roaster> roaster = roasterRepo.findById(id);

        if (!roaster.isPresent()) {
            return null;
        }

        return roaster.get();
    }

    @PutMapping(value = "/{id}")
    public void updateRoaster(@RequestBody Roaster roaster, @PathVariable int id) {
        if(roaster.getId() == null) {
            roaster.setId(id);
        }

        if(roaster.getId() != id) {
            throw new IllegalArgumentException("Roaster ID must match parameter given");
        }
        roasterRepo.save(roaster);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRoaster(@PathVariable int id) {
        roasterRepo.deleteById(id);
    }

}
