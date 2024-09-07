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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Vitrine_App extends Application {
    private AnchorPane pane;
    private TextField txSearch;
    private TableView<ItensProperty> tbVitrine;
    private TableColumn<ItensProperty, String> columnProduct;
    private TableColumn<ItensProperty, Double> columnPrice;
    private static ObservableList<ItensProperty> listItens = FXCollections
            .observableArrayList();
    private static Vitrine_Cart cart;

    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(800, 600);

        txSearch = new TextField();
        txSearch.setPromptText("Digite o item para pesquisa");
        txSearch.setLayoutY(10);
        txSearch.setLayoutX(640);

        tbVitrine = new TableView<ItensProperty>();
        tbVitrine.setPrefSize(780, 550);
        tbVitrine.setLayoutY(40);
        tbVitrine.setLayoutX(10);

        columnProduct = new TableColumn<ItensProperty, String>();
        columnPrice = new TableColumn<ItensProperty, Double>();
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

        for(Vitrine_Product p : v.getProducts())
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
    }

    private ObservableList<ItensProperty> findItens() {
        ObservableList<ItensProperty> foundItens = FXCollections.observableArrayList();

        for(ItensProperty itens : listItens)
            if(itens.getProduct().contains(txSearch.getText())) foundItens.add(itens);

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

    public static void main(String[] args) {
        launch(args);
    }

    public class ItensProperty {
        private SimpleStringProperty product;
        private SimpleDoubleProperty price;

        public ItensProperty(String product, double price) {
            this.product = new SimpleStringProperty(product);
            this.price = new SimpleDoubleProperty(price);
        }

        public String getProduct() {
            return product.get();
        }

        public void setProduct(String product) {
            this.product.set(product);
        }

        public double getPrice() {
            return price.get();
        }

        public void setPrice(double price) {
            this.price.set(price);
        }

        //  public SimpleStringProperty productProperty() {
        //      return product;
        //  }

        //  public SimpleDoubleProperty priceProperty() {
        //      return price;
        //  }
    }
}
