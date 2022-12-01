package com.example.aquarium.view;

import com.example.aquarium.model.Fish;
import com.example.aquarium.model.Position;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.InputStream;
import java.util.Optional;
import java.util.Random;

public class FishView extends ImageView {
    private final Timeline timeline;
    private final Random random = new Random();
    private final Position initPosition;

    public FishView(Fish fish) {

        Optional<InputStream> resourceAsStream
                = Optional.ofNullable(getClass().getResourceAsStream(fish.getImage()));
        if (resourceAsStream.isPresent()) {
            Image image = new Image(resourceAsStream.get());
            this.setImage(image);
        }

        // init fish
        initPosition = getRandomPosition();
        this.setLayoutX(initPosition.getX());
        this.setLayoutY(initPosition.getY());

        // init timeline
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
    }

    public Position playRandomMovement() {
        // generate next random position for fish
        Position newPos = getRandomPosition();

        // initial values (resetting)
        initPosition.setX(this.getLayoutX());
        initPosition.setY(this.getLayoutY());

        //rotate fish in direction of movement
        if (initPosition.getX() < newPos.getX()) {
            this.setScaleX(-1);
        } else {
            this.setScaleX(1);
        }

        // target values
        KeyValue kx = new KeyValue(this.layoutXProperty(), newPos.getX());
        KeyValue ky = new KeyValue(this.layoutYProperty(), newPos.getY());

        // restart timeline with new values
        timeline.stop();
        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000),
                (e) -> playRandomMovement(), kx, ky));
        timeline.play();

        return newPos;
    }

    private Position getRandomPosition() {
        int x = random.nextInt(690);
        int y = random.nextInt(490);
        Position p = new Position();
        p.setX(x);
        p.setY(y);
        return p;
    }

}

