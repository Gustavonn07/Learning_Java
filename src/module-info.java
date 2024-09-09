module Learning.Java {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;

    opens random;
    opens random.JavaFX;
    opens random.JavaFX.CasaDoCodigo;
    opens random.JavaFX.CasaDoCodigo.Vitrine;
    opens random.JavaFX.CasaDoCodigo.Item;
    opens random.JavaFX.CasaDoCodigo.Cart;
}