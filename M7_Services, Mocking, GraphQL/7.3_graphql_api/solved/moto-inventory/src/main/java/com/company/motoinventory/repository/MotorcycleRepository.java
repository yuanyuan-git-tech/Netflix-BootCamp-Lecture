package com.company.motoinventory.repository;

import com.company.motoinventory.models.Motorcycle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MotorcycleRepository {

    public MotorcycleRepository() {
        seedDataStore();
    }

    private List<Motorcycle> motorcycles = new ArrayList<Motorcycle>();

    private void seedDataStore() {
        Motorcycle m1 = new Motorcycle("11111", "Honda", "Street Cruiser", 1988);
        Motorcycle m2 = new Motorcycle("22222", "Yamaha", "Moto Cross X", 2005);
        this.motorcycles.add(m1);
        this.motorcycles.add(m2);

    }

    // Retrieve all motorcycles
    public List<Motorcycle> getMotorcycles() {
        return this.motorcycles;
    }

    // Retrieve a motorcycle by Id
    public Motorcycle getMotorcycleById(String id) {
        List<Motorcycle> idMatch = this.motorcycles;
        Motorcycle resultMotorcycle = null;
        for (Motorcycle m : idMatch) {
            if (m.getId().equals(id)) {
                resultMotorcycle = m;
            }
        }
        return resultMotorcycle;
    }

    // Add a motorcycle
    public Motorcycle addMotorcycle(String id, String make, String model, int year) {
        Motorcycle newMotorcycle = new Motorcycle(id, make, model, year);
        this.motorcycles.add(newMotorcycle);
        return newMotorcycle;
    }

    // Update a motorcycle
    public Motorcycle updateMotorcycle(Motorcycle motorcycle) {

        for (Motorcycle m : motorcycles) {
            int indexNumber = -1;
            if (m.getId().equals(motorcycle.getId())) {
                indexNumber = motorcycles.indexOf(m);
                motorcycles.set(indexNumber, motorcycle);
                return motorcycle;
            }
        }
        return null;
    }

    // Delete Motorcycle by Id
    public boolean deleteMotorcycleById(String id) {
        for (Motorcycle m : motorcycles) {
            int indexNumber = -1;
            if (m.getId().equals(id)) {
                indexNumber = motorcycles.indexOf(m);
                motorcycles.remove(indexNumber);
                return true;
            }
        }
        return false;
    }

}