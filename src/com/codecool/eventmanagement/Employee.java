package com.codecool.eventmanagement;

public abstract class Employee {

    protected String name;
    protected static int counter = 0;

    public Employee(String name) {
        this.name = name;
    }

}
