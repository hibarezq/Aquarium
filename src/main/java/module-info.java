module com.example.aquarium {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.aquarium to javafx.fxml;
    exports com.example.aquarium;
}