package com.example.aquarium.view;

import com.example.aquarium.model.Aquarium;
import com.example.aquarium.model.Fish;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Getter;

@Getter
public class AquariumView {
    private final Button addFishBtn;
    private final Button deleteFishBtn;
    private final TankView tankView;
    private final VBox aquariumView;

    public AquariumView(Aquarium aquarium) {
        addFishBtn = new Button("Add Fish");
        deleteFishBtn = new Button("Delete Fish");
        tankView = new TankView(aquarium);
        aquariumView = makeAquarium();
    }

    private VBox makeAquarium() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(tankView, makeButtons());
        return vBox;
    }

    private HBox makeButtons() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
        addFishBtn.setPrefSize(200, 40);
        deleteFishBtn.setPrefSize(200, 40);
        hBox.getChildren().addAll(addFishBtn, deleteFishBtn);
        return hBox;
    }

    public void updateAquarium() {
        Platform.runLater(() -> {
            this.tankView.getChildren().removeIf(node -> node instanceof FishView);
            for (int i = 0; i < tankView.getAquarium().getNbFish(); i++) {
                FishView pcg = new FishView(new Fish());
                this.tankView.getChildren().add(pcg);
            }
        });
    }

    /**
     * Display an alert box
     *
     * @param message The text to display in the alert box
     */
    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
