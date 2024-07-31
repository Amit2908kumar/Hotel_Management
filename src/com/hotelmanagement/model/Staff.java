// Staff.java
package com.hotelmanagement.model;

public class Staff implements IStaff {
    private int id;
    private String name;
    private String position;
    private double salary;

    public Staff(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}

