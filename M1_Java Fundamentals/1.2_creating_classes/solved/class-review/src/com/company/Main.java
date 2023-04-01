package com.company;

public class Main {
    public static void main(String[] args) {
        Person jim = new Person("Jim");
        Person callie = new Person("Callie");
        jim.sayHello();
        callie.sayHello();
        System.out.println(jim.getCreatedDate());
        System.out.println(callie.getCreatedDate());
    }
}
