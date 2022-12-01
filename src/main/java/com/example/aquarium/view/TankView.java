package com.example.aquarium.view;

import com.example.aquarium.model.Aquarium;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import lombok.Getter;

import java.io.InputStream;
import java.util.Optional;

@Getter
public class TankView extends Group {
    private final Aquarium aquarium;

    public TankView(Aquarium aquarium) {
        this.aquarium = aquarium;
        this.getChildren().add(makeTank());
    }

    public Pane makeTank() {
        Pane tank = new Pane();
        tank.setPrefSize(800, 550);
        ImageView iv = returnImageView();
        iv.setFitHeight(550);
        iv.setFitWidth(800);
        tank.getChildren().add(iv);
        return tank;
    }

    public ImageView returnImageView() {
        ImageView imageView = new ImageView();
        Optional<InputStream> resourceAsStream
                = Optional.ofNullable(TankView.class.getResourceAsStream(aquarium.getBackground()));
        if (resourceAsStream.isPresent()) {
            Image image = new Image(resourceAsStream.get());
            imageView = new ImageView(image);
        }
        return imageView;
    }

}

