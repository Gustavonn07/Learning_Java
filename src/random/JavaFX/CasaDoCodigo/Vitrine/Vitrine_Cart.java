package random.JavaFX.CasaDoCodigo.Vitrine;

import java.util.ArrayList;
import java.util.List;

public class Vitrine_Cart {
    private static List<Vitrine_Product> products = new ArrayList<Vitrine_Product>();

    protected void addProducts(Vitrine_Product... ps) {
        for(Vitrine_Product p : ps) products.add(p);
    }

    protected List<Vitrine_Product> getProducts() {
        return products;
    }
}
