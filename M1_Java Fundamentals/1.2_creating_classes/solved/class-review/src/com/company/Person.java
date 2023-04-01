package com.company;

import java.util.Date;

public class Person {
    private String name;
    private Date createdDate;

    public Person(String name) {
        this.name = name;
        this.createdDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void sayHello() {
        System.out.println("Hello, I am " + this.name);
    }
}
