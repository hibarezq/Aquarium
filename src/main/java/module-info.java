module com.example.aquarium {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aquarium to javafx.fxml;
    exports com.example.aquarium;
}