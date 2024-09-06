package random.JavaFX.Login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

        TextField txLogin = new TextField();
        txLogin.setPromptText("Digite aqui o seu email");

        PasswordField txPassword = new PasswordField();
        txPassword.setPromptText("Digite aqui a sua senha");

        Button btnJoin = new Button("Join");
        Button btnLeave = new Button("Leave");

        pane.getChildren().addAll(txLogin, txPassword, btnJoin, btnLeave);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        double paneWidth = pane.getWidth();

        txLogin.setLayoutX((paneWidth - txLogin.getWidth()) / 2);
        txLogin.setLayoutY(70);

        txPassword.setLayoutX((paneWidth - txPassword.getWidth()) / 2);
        txPassword.setLayoutY(110);

        btnJoin.setLayoutX((paneWidth - txLogin.getWidth()) / 2);
        btnJoin.setLayoutY(150);

        btnLeave.setLayoutX((paneWidth - txLogin.getWidth()) / 1.5 + 10);
        btnLeave.setLayoutY(150);

        pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #C6C6FF 0%, #C6FFC6 100%);");
    }
}
