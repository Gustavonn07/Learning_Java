package random.JavaFX.CasaDoCodigo.Vitrine;

import java.util.ArrayList;
import java.util.List;

public class Vitrine_Vitrine {
    private static List<Vitrine_Product> products = new ArrayList<Vitrine_Product>();

    public void addProducts(Vitrine_Product... ps) {
        for(Vitrine_Product p : ps) products.add(p);
    }

    public List<Vitrine_Product> getProducts() {
        return products;
    }
}
