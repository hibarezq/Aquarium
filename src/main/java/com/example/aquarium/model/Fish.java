package com.example.aquarium.model;

import lombok.Getter;

import java.util.Random;

@Getter
public class Fish {
    private final String image;
    private final double x;
    private final double y;

    public Fish() {
        image = "/com/example/aquarium/goldfish.png";
        Random random = new Random();
        x = random.nextDouble() * (690);
        y = random.nextDouble() * (490);
    }
}
