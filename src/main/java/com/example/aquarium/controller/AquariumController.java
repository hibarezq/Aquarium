package com.example.aquarium.controller;

import com.example.aquarium.model.Aquarium;
import com.example.aquarium.view.AquariumView;

public class AquariumController {
    Aquarium aquarium;

    public AquariumController(AquariumView aquariumVue) {
        aquarium = aquariumVue.getTankView().getAquarium();
        aquariumVue.getAddFishBtn().setOnAction(event -> {
            aquarium.addFish();
            aquariumVue.updateAquarium();

        });
        aquariumVue.getDeleteFishBtn().setOnAction(event -> {
            if (aquarium.getNbFish() <= 0) {
                aquariumVue.showAlert("There Are No Fish In This Tank!");
            } else {
                aquarium.deleteFish();
                aquariumVue.updateAquarium();
            }
        });
    }
}