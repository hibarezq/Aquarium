package com.example.aquarium.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AquariumTest {
    private Aquarium aquarium;

    @BeforeEach
    public void init() {
        this.aquarium = new Aquarium();
    }

    @Test
    void addFish() {
        int nbFish = aquarium.addFish();
        assertEquals(nbFish, 1);
    }

    @Test
    void deleteFish() {
        int nbFish = aquarium.deleteFish();
        assertEquals(nbFish, 0);
    }
}