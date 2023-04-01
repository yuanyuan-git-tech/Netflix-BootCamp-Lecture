package com.company.motoinventory.models;

import java.util.Objects;

public class Motorcycle {
    private String id;
    private String make;
    private String model;
    private int year;

    public Motorcycle() {
    }

    public Motorcycle(String id, String make, String model, int year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Motorcycle)) return false;
        Motorcycle that = (Motorcycle) o;
        return getYear() == that.getYear() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getMake(), that.getMake()) &&
                Objects.equals(getModel(), that.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMake(), getModel(), getYear());
    }

}
