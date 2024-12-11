package com.project.models;

import com.project.enums.Color;
import com.project.enums.DeviceType;

public class Device {
    private final String name;
    private final int year;
    private final double price;
    private final Color color;
    private final DeviceType type;

    public Device(String name, int year, double price, Color color, DeviceType type) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Name:" + name + ", Year:" + year + ", Price:" + price + ", Color:" + color + ", Type:" + type;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    public DeviceType getType() {
        return type;
    }
}
