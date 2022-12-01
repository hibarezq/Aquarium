package com.example.aquarium.model;

import lombok.Getter;

@Getter
public class Fish {
    private final String image;

    public Fish() {
        image = "/com/example/aquarium/goldfish.png";
    }
}
