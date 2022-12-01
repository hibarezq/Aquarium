package com.example.aquarium.view;

import com.example.aquarium.model.Fish;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.Optional;

public class FishView extends ImageView {

    public FishView(Fish fish) {

        Optional<InputStream> resourceAsStream
                = Optional.ofNullable(getClass().getResourceAsStream(fish.getImage()));
        if (resourceAsStream.isPresent()) {
            Image image = new Image(resourceAsStream.get());
            this.setImage(image);
        }
        this.setLayoutX(fish.getX());
        this.setLayoutY(fish.getY());
    }

}

