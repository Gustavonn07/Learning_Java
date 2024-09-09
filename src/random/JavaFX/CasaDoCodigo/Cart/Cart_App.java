package random.JavaFX.CasaDoCodigo.Cart;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import random.JavaFX.CasaDoCodigo.Item.Item_App;
import random.JavaFX.CasaDoCodigo.Vitrine.Vitrine_App;
import random.JavaFX.CasaDoCodigo.Vitrine.Vitrine_Product;

public class Cart_App extends Application {
    private AnchorPane pane;
    private TableView<Vitrine_App.ItensProperty> tbCart;
    private TableColumn<Vitrine_App.ItensProperty, String> columnProduct;
    private TableColumn<Vitrine_App.ItensProperty, Double> columnPrice;
    private Button btnDeleteItem, btnBackVitrine, btnConfirmPurchase;
    private ObservableList<Vitrine_App.ItensProperty> listItens = FXCollections.observableArrayList();
    private static Stage stage;

    private void initItems() {
        listItens.clear();
        for (Vitrine_Product p : Vitrine_App.cart.getProducts()) {
            listItens.add(new Vitrine_App.ItensProperty(p.getProduct(), p.getPrice()));
        }
    }

    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(600, 400);

        tbCart = new TableView<>();
        tbCart.setItems(listItens);
        tbCart.setPrefSize(400, 300);
        tbCart.setLayoutX(50);
        tbCart.setLayoutY(50);

        columnProduct = new TableColumn<>("Produto");
        columnProduct.setCellValueFactory(cellData -> cellData.getValue().PRODUCTProperty());

        columnPrice = new TableColumn<>("Preço");
        columnPrice.setCellValueFactory(cellData -> cellData.getValue().PRICEProperty().asObject());

        tbCart.getColumns().addAll(columnProduct, columnPrice);

        btnDeleteItem = new Button("Delete Item");
        btnDeleteItem.setLayoutX(50);
        btnDeleteItem.setLayoutY(360);

        btnConfirmPurchase = new Button("Confirm Purchase");
        btnConfirmPurchase.setLayoutX(150);
        btnConfirmPurchase.setLayoutY(360);

        btnBackVitrine = new Button("Back to Vitrine");
        btnBackVitrine.setLayoutX(300);
        btnBackVitrine.setLayoutY(360);

        pane.getChildren().addAll(tbCart, btnDeleteItem, btnConfirmPurchase, btnBackVitrine);
    }

    private void initListeners() {
        btnDeleteItem.setOnAction(event -> {
            Vitrine_App.ItensProperty selectedItem = tbCart.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                Vitrine_App.cart.deleteProduct(new Vitrine_Product(selectedItem.getProduct(), selectedItem.getPrice()));
                tbCart.getItems().remove(selectedItem);
            }
        });

        btnBackVitrine.setOnAction(event -> {
            Cart_App.getStage().close();
            Item_App.getStage().close();
        });

        btnConfirmPurchase.setOnAction(event -> {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {
                    new Alert(Alert.AlertType.INFORMATION, "Compra realizada com sucesso!").showAndWait();
                    Cart_App.getStage().close();
                    Item_App.getStage().close();
                });
            });
            thread.start();
        });
    }

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Cart_App.stage = stage;
        initComponents();
        initItems();
        initListeners();

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
