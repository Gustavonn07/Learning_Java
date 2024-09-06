package random.JavaFX.Login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = new AnchorPane();
        pane.setPrefSize(400, 300);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
