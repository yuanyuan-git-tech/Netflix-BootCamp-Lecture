package com.company.controller;

import com.company.model.Roaster;
import com.company.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/roasters")
public class RoasterController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    public Roaster createRoaster(@RequestBody Roaster roaster) {
        return serviceLayer.saveRoaster(roaster);
    }

    @GetMapping
    public List<Roaster> getAllRoasters() {
        return serviceLayer.findAllRoasters();
    }

    @GetMapping(value = "/{id}")
    public Roaster getRoasterById(@PathVariable int id) {
        return serviceLayer.findRoaster(id);
    }

    @PutMapping(value = "/{id}")
    public void updateRoaster(@RequestBody Roaster roaster, @PathVariable int id) {
        serviceLayer.saveRoaster(roaster);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRoaster(@PathVariable int id) {
        serviceLayer.removeRoaster(id);
    }

}
