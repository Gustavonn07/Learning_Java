package random.JavaFX.CasaDoCodigo.Cart;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import random.JavaFX.CasaDoCodigo.Item.Item_App;
import random.JavaFX.CasaDoCodigo.Vitrine.Vitrine_App;

import javafx.scene.control.*;
import random.JavaFX.CasaDoCodigo.Vitrine.Vitrine_Product;

import javax.swing.*;

public class Cart_App extends Application {
    private AnchorPane pane;
    private TableView<Vitrine_App.ItensProperty> tbCart;
    private TableColumn<Vitrine_App.ItensProperty, String> columnProduct;
    private TableColumn<Vitrine_App.ItensProperty, Double> columnPrice;
    private Button btnDeleteItem, btnBackVitrine, btnConfirmPurchase;
    private static ObservableList<Vitrine_App.ItensProperty> listItems;
    private static Stage stage;

    private void initItems() {
        for (Vitrine_Product p : Vitrine_App.cart.getProducts())
            listItems.add(new Vitrine_App.ItensProperty(p.getProduct(), p.getPrice()));
    }

    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(600, 400);
    }

    private void initListeners() {
        btnDeleteItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Vitrine_App.cart.deleteProduct(new Vitrine_Product(tbCart
                        .getSelectionModel().getSelectedItem().getProduct(),
                        tbCart.getSelectionModel().getSelectedItem().getPrice()));

                tbCart.getItems().remove(
                        tbCart.getSelectionModel().getSelectedItem());
            }
        });

        btnBackVitrine.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                Cart_App.getStage().close();
                Item_App.getStage().close();
            }
        });

        btnConfirmPurchase.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Thread thread = new Thread() {
                    public void run() {
                        try {
                            sleep(5000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null,
                                "Compra realizada com sucesso!");
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Cart_App.getStage().close();
                                Item_App.getStage().close();
                            }
                        });
                    };
                };
                thread.start();
            }
        });
    }

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        initComponents();
        initItems();
        initListeners();

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Item Details");
        stage.show();
    }
}
