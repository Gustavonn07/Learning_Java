module Learning.Java {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;

    opens random.JavaFX.Login;
    opens random.JavaFX;
}