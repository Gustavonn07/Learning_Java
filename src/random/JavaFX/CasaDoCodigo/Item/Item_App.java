package random.JavaFX.CasaDoCodigo.Item;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import random.JavaFX.CasaDoCodigo.Cart.Cart_App;
import random.JavaFX.CasaDoCodigo.Vitrine.Vitrine_App;
import random.JavaFX.CasaDoCodigo.Vitrine.Vitrine_Product;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Item_App extends Application {
    private AnchorPane pane;
    private ImageView imgItem;
    private Label lbPrice, lbDescription;
    private Button btnAddCart;
    private static Stage stage;
    private static Vitrine_Product product;
    private static int index;
    private static String[] images = {
            // Em um projeto real, trocar as fotos pela imagens do produto:
            "https://img.freepik.com/fotos-gratis/ferramentas-esportivas_53876-138077.jpg",
            "https://img.freepik.com/fotos-gratis/ferramentas-esportivas_53876-138077.jpg",
            "https://img.freepik.com/fotos-gratis/ferramentas-esportivas_53876-138077.jpg",
            "https://img.freepik.com/fotos-gratis/ferramentas-esportivas_53876-138077.jpg",
            "https://img.freepik.com/fotos-gratis/ferramentas-esportivas_53876-138077.jpg"
    };

    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(600, 400);

        imgItem = new ImageView();
        imgItem.setImage(new Image(images[index]));
        imgItem.setFitWidth(300);
        imgItem.setFitHeight(180);
        imgItem.setEffect(new Reflection());
        imgItem.setX(150);
        imgItem.setY(20);

        lbDescription = new Label(product.getProduct());
        lbDescription.setLayoutX(240);
        lbDescription.setLayoutY(230);

        lbPrice = new Label(product.getPrice() + " ");
        lbPrice.setLayoutX(240);
        lbPrice.setLayoutY(250);

        btnAddCart = new Button("Add to Cart");
        btnAddCart.setEffect(new InnerShadow());
        btnAddCart.setLayoutX(260);
        btnAddCart.setLayoutY(290);

        pane.getChildren().addAll(imgItem, lbPrice, lbDescription, btnAddCart);
    }

    private void initListeners() {

        btnAddCart.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                Vitrine_App.cart.addProducts(product);

                try {
                    new Cart_App().start(new Stage());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static Stage getStage() {
        return stage;
    }

    public static Vitrine_Product getProduct() {
        return product;
    }

    public static void setProduct(Vitrine_Product product) {
        Item_App.product = product;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        Item_App.index = index;
    }

    @Override
    public void start(Stage stage) {
        initComponents();
        initListeners();

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Item Details");
        stage.show();

        Item_App.stage = stage;
    }
}
