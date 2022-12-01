package com.example.aquarium.model;

import lombok.Getter;

@Getter
public class Aquarium {
    private final String background;
    private int nbFish;

    public Aquarium() {
        this.background = "/com/example/aquarium/fish-tank.png";
    }

    public int addFish() {
        return nbFish += 1;
    }

    public int deleteFish() {
        return nbFish > 0 ? nbFish -= 1 : nbFish;
    }
}
