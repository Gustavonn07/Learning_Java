package random.JavaFX.CasaDoCodigo.Vitrine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vitrine_Cart {
    private static List<Vitrine_Product> products = new ArrayList<Vitrine_Product>();

    public void addProducts(Vitrine_Product... ps) {
        for(Vitrine_Product p : ps) products.add(p);
    }

    public void deleteProduct(Vitrine_Product p) {
        Iterator<Vitrine_Product> itProduct = products.iterator();

        while (itProduct.hasNext()) {
            Vitrine_Product product = itProduct.next();

            if (product.getProduct().equals(p.getProduct())
                    && product.getPrice() == p.getPrice()) {
                itProduct.remove();
            }
        }
    }

    public List<Vitrine_Product> getProducts() {
        return products;
    }
}
