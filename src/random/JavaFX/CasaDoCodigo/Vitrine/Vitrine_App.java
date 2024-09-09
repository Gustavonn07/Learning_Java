package random.JavaFX.CasaDoCodigo.Vitrine;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import random.JavaFX.CasaDoCodigo.Item.Item_App;

public class Vitrine_App extends Application {
    private AnchorPane pane;
    private TextField txSearch;
    private TableView<ItensProperty> tbVitrine;
    private TableColumn<ItensProperty, String> columnProduct;
    private TableColumn<ItensProperty, Double> columnPrice;
    private static ObservableList<ItensProperty> listItens = FXCollections.observableArrayList();
    public static Vitrine_Cart cart;

    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(800, 600);

        txSearch = new TextField();
        DropShadow ds = new DropShadow();
        ds.setSpread(0.5);
        ds.setColor(Color.RED);
        txSearch.setEffect(ds);
        txSearch.setPromptText("Digite o item para pesquisa");
        txSearch.setLayoutY(10);
        txSearch.setLayoutX(640);

        tbVitrine = new TableView<>();
        tbVitrine.setPrefSize(780, 550);
        tbVitrine.setLayoutY(40);
        tbVitrine.setLayoutX(10);

        columnProduct = new TableColumn<ItensProperty, String>("Product");
        columnPrice = new TableColumn<ItensProperty, Double>("Price");
        tbVitrine.getColumns().addAll(columnProduct, columnPrice);
        pane.getChildren().addAll(txSearch, tbVitrine);

        cart = new Vitrine_Cart();

        columnProduct.setCellValueFactory(
                new PropertyValueFactory<ItensProperty, String>("product"));
        columnPrice.setCellValueFactory(
                new PropertyValueFactory<ItensProperty, Double>("price"));
    }

    private void initItens() {
        Vitrine_Vitrine v = new Vitrine_Vitrine();
        v.addProducts(
                new Vitrine_Product("Bola Topper", 15.00),
                new Vitrine_Product("Luvas Umbro", 9.00),
                new Vitrine_Product("Camisa Esportiva", 40.00),
                new Vitrine_Product("Chuteira Nike Mercurial", 199.00),
                new Vitrine_Product("Caneleira Topper", 10.00)
        );

        for (Vitrine_Product p : v.getProducts())
            listItens.add(new ItensProperty(p.getProduct(), p.getPrice()));

        tbVitrine.setItems(listItens);
    }

    private void initListeners() {

        txSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!txSearch.getText().equals("")) {
                    tbVitrine.setItems(findItens());
                } else {
                    tbVitrine.setItems(listItens);
                }
            }
        });

        tbVitrine.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldItem, newItem) -> {
            Item_App.setProduct(new Vitrine_Product(newItem.getProduct(), newItem.getPrice()));
            Item_App.setIndex(tbVitrine.getSelectionModel().getSelectedIndex());

            try {
                new Item_App().start(new Stage());

            } catch (Exception err) {
                err.printStackTrace();
            }
        });
    }

    private ObservableList<ItensProperty> findItens() {
        ObservableList<ItensProperty> foundItens = FXCollections.observableArrayList();

        for (ItensProperty itens : listItens)
            if (itens.getProduct().contains(txSearch.getText())) foundItens.add(itens);

        return foundItens;
    }

    @Override
    public void start(Stage stage) throws Exception {
        initComponents();
        initItens();
        initListeners();

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Vitrine");
        stage.show();
    }

    public static class ItensProperty {
        private final SimpleStringProperty PRODUCT;
        private final SimpleDoubleProperty PRICE;

        public ItensProperty(String PRODUCT, double PRICE) {
            this.PRODUCT = new SimpleStringProperty(PRODUCT);
            this.PRICE = new SimpleDoubleProperty(PRICE);
        }

        public String getProduct() {
            return PRODUCT.get();
        }

        public void setProduct(String PRODUCT) {
            this.PRODUCT.set(PRODUCT);
        }

        public double getPrice() {
            return PRICE.get();
        }

        public void setPrice(double PRICE) {
            this.PRICE.set(PRICE);
        }

        public SimpleStringProperty PRODUCTProperty() {
            return PRODUCT;
        }

        public SimpleDoubleProperty PRICEProperty() {
            return PRICE;
        }
    }
}
