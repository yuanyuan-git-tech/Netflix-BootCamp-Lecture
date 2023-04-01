package com.company.citywebservice.models;

public class City {

    private String name;
    private String state;
    private int population;
    private boolean capital;

    public City() {}

    public City(String name, String state, int population, boolean capital) {
        this.name = name;
        this.state = state;
        this.population = population;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }
}
