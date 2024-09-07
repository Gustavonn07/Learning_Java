package random.JavaFX.CasaDoCodigo.Vitrine;

public class Vitrine_Product {
    private String product;
    private double price;

    protected Vitrine_Product(String product, double price) {
        this.product = product;
        this.price = price;
    }

    protected String getProduct() {
        return product;
    }

    protected void setProduct(String product) {
        this.product = product;
    }

    protected double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }
}
