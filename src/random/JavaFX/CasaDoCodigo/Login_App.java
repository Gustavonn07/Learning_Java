package random.JavaFX.CasaDoCodigo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import random.JavaFX.CasaDoCodigo.Vitrine.Vitrine_App;

import javax.swing.*;

public class Login_App extends Application {
    private AnchorPane pane;
    private TextField txLogin;
    private PasswordField txPassword;
    private Button btnJoin, btnLeave;
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    };

    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(400, 300);
        pane.getStyleClass().add("pane");

        txLogin = new TextField();
        txLogin.setPromptText("Digite aqui o seu login");

        txPassword = new PasswordField();
        txPassword.setPromptText("Digite aqui a sua senha");

        btnJoin = new Button("Join");
        btnJoin.getStyleClass().addAll("btn", "join");

        btnLeave = new Button("Leave");
        btnLeave.getStyleClass().addAll("btn", "leave");
    }

    private void initLayout() {
        pane.getChildren().addAll(txLogin, txPassword, btnJoin, btnLeave);

        double paneWidth = pane.getWidth();

        txLogin.setLayoutX(paneWidth / 2 - 80);
        txLogin.setLayoutY(70);

        txPassword.setLayoutX(paneWidth / 2 - 80);
        txPassword.setLayoutY(110);

        btnJoin.setLayoutX(paneWidth / 2 - 80);
        btnJoin.setLayoutY(150);

        btnLeave.setLayoutX(paneWidth / 2 - 30);
        btnLeave.setLayoutY(150);
    }

    private void initListeners() {
        btnLeave.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                closeApplication();
            }
        });

        btnJoin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                openApplication();
            }
        });
    }

    private void closeApplication() {
        System.exit(0);
    }

    private void openApplication() {
        if(txLogin.getText().equals("admin") &&
                txPassword.getText().equals("senhaforte")) {
            try {
                Vitrine_App vitrineApp = new Vitrine_App();
                vitrineApp.start(new Stage());
                Login_App.getStage().close();

            } catch (Exception err) {
                err.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Login e/ou senha inválidos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        initComponents();
        initListeners();

        Scene scene = new Scene(pane);
        scene.getStylesheets().add("random/JavaFX/CasaDoCodigo/Login.css");

        stage.setResizable(false);
        stage.setTitle("Login - GolFX");
        stage.setScene(scene);
        stage.show();

        initLayout();
        Login_App.stage = stage;

    }

    public static void main(String[] args) {
        launch(args);
    }
}
