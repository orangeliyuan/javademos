package per.example.java8.program;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class demo27 {
    public static void main(String[] args) {
        Product p1 = ProductFactory.createPorduct("load");

        Supplier<Product> loanSupplier = Loan::new;
        Product p2 = loanSupplier.get();

        Product p3 = ProductFactory.createProductLambda("load");
    }

    static private class ProductFactory {
        public static Product createPorduct(String name) {
            switch (name) {
                case "loan": return new Loan();
                case "stock": return new Stock();
                case "bond": return new Bond();
                default: throw new RuntimeException("No such product " + name);
            }
        }
        public static Product createProductLambda(String name) {
            Supplier<Product> p = map.get(name);
            if (p != null) {
                return p.get();
            }
            throw new RuntimeException("No such product " + name);
        }
    }

    private interface Product {}
    static private class Loan implements Product{}
    static private class Stock implements Product{}
    static private class Bond implements Product{}

    final static private Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("load", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }
}
