
package com.hotelmanagement.model;

public class Room implements IRoom {
    private int id;
    private String number;
    private String type;
    private double price;

    public Room(int id, String number, String type, double price) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
