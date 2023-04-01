package com.company;

public class Breeder {
    public Dog breedDogs(Dog dog1, Dog dog2) {
        Dog newDog = new Dog();
        newDog.setAge(0);
        newDog.setColor(dog1.getColor() + dog2.getColor());
        newDog.setFavToy(dog1.getFavToy());

        return newDog;
    }
}
