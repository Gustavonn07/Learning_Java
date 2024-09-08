package random.JavaFX.CasaDoCodigo.Item;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import random.JavaFX.CasaDoCodigo.Vitrine.Vitrine_Product;

public class Item_App extends Application {
    private AnchorPane pane;
    private ImageView imgItem;
    private Label lbPrice, lbDescription;
    private Button btnAddCart;
    private static Stage stage;
    private static Vitrine_Product product;
    private static int index;
    private static String[] images = {
            "http://www.sportcenterlopes.com.br/images/" +
                    "250_topper_campo_2009replic.jpg",
            "http://1.bp.blogspot.com/_H8uGs8K8kaY/TLZTXR8nIgI/" +
                    "AAAAAAAAF_0/BvpxdqGF4PE/s1600/luva_umbro.png",
            "http://bimg2.mlstatic.com/camisa-nike-active-importada-manga-" +
                    "longa-esportiva-vermelha_MLB-F-199843960_1391.jpg",
            "http://www.showtenis.com.br/images/_product/979/979112/" +
                    "chuteira-nike-mercurial-glide-3-fg-campo--199fd9.jpg",
            "http://www.katy.com.br/imagens/produtos/original/" +
                    "caneleira-topper-trainning-difusion-13340619502673137.jpg"
    };

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
        pane = new AnchorPane();
        pane.setPrefSize(600, 400);

        imgItem = new ImageView();
        imgItem.setImage(new Image(images[index]));

        lbPrice = new Label("Price: " + product.getPrice());
        lbDescription = new Label("Description: " + product.getProduct());

        btnAddCart = new Button("Add to Cart");

        pane.getChildren().addAll(imgItem, lbPrice, lbDescription, btnAddCart);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Item Details");
        stage.show();
    }
}
