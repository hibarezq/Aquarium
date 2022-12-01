package com.example.aquarium.view;

import com.example.aquarium.model.Fish;
import com.example.aquarium.model.Position;
import javafx.application.Platform;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FishViewTest {

    @Test
    void playRandomMovement() {
        //Given
        Platform.startup(() -> { });
        Fish fish=new Fish();
        FishView fishView = new FishView(fish);
        double oldX = fishView.getX();
        double oldY = fishView.getY();

        //When
        Position newPos= fishView.playRandomMovement();

        //Then
        assertNotEquals(oldX, newPos.getX());
        assertNotEquals(oldY, newPos.getY());
    }
}