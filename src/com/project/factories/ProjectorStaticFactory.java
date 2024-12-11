package com.project.factories;

import com.project.enums.Color;
import com.project.enums.DeviceType;
import com.project.models.Device;
import com.project.models.Projector;

import java.util.Random;

public class ProjectorStaticFactory {

    private static final String[] names = new String[]{"ZephyrX", "NovaCore", "AstraLite", "QuantumEdge", "VortexPrime", "LunaSpark", "EchoWave", "PulseGear", "NimbusFlow", "ZenithArc"};
    private static final String[] manufacturers = new String[]{"Samsung", "Apple", "Sony", "LG", "Dell", "HP", "Lenovo", "Asus", "Acer", "Microsoft", "Intel", "AMD", "Nvidia", "Tesla", "Toyota", "Ford", "Honda", "Caterpillar", "Boeing", "Philips"};

    public static Projector getProjector() {
        Random random = new Random();
        return new Projector(names[random.nextInt(0, names.length)] +" "+ random.nextInt(1,30),
                random.nextInt(2019, 2025),
                (double) Math.round(random.nextDouble(100, 10000) * 100) / 100,
                manufacturers[random.nextInt(0,manufacturers.length)]);
    }
}
