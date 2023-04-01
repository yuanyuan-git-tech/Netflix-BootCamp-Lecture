package com.company;

import java.util.Objects;

public class Dog {

    private int age;
    private String color;
    private String favToy;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFavToy() {
        return favToy;
    }

    public void setFavToy(String favToy) {
        this.favToy = favToy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return getAge() == dog.getAge() &&
                Objects.equals(getColor(), dog.getColor()) &&
                Objects.equals(getFavToy(), dog.getFavToy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getAge(), getFavToy());
    }
}
