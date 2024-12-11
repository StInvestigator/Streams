package com.project.factories;

import com.project.enums.Color;
import com.project.enums.DeviceType;
import com.project.models.Device;

import java.util.Random;

public class DeviceStaticFactory {

    private static final String[] names = new String[]{"ZephyrX", "NovaCore", "AstraLite", "QuantumEdge", "VortexPrime", "LunaSpark", "EchoWave", "PulseGear", "NimbusFlow", "ZenithArc"};

    public static Device getDevice() {
        Random random = new Random();
        return new Device(names[random.nextInt(0, names.length)] +" "+ random.nextInt(1,30),
                random.nextInt(2019, 2025),
                (double) Math.round(random.nextDouble(100, 10000) * 100) / 100,
                Color.values()[random.nextInt(0, Color.values().length)],
                DeviceType.values()[random.nextInt(0, DeviceType.values().length)]);
    }
}
