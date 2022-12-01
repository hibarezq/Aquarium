package com.example.aquarium;

import com.example.aquarium.controller.AquariumController;
import com.example.aquarium.model.Aquarium;
import com.example.aquarium.view.AquariumView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AquariumApplication extends Application {
    @Override
    public void start(Stage stage) {
        Aquarium aquarium = new Aquarium();
        AquariumView aquariumVue = new AquariumView(aquarium);
        new AquariumController(aquariumVue);
        Scene scene = new Scene(aquariumVue.getAquariumView());
        stage.setTitle("AQUARIUM");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}