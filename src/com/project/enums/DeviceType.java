package com.project.enums;

public enum DeviceType {
    SMARTPHONE,
    DESKTOP,
    LAPTOP,
    REMOTE,
    SMART_WATCH;

    @Override
    public String toString() {
        return name().toLowerCase().replace("_", " ");
    }
}
