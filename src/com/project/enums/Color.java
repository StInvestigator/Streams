package com.project.enums;

public enum Color {
    BLACK,
    WHILE,
    PURPLE,
    COSMOS,
    RED,
    YELLOW,
    GREEN,
    BLUE;

    @Override
    public String toString() {
        return name().toLowerCase().replace("_", " ");
    }
}
