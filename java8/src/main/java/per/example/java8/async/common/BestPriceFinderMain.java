package per.example.java8.async.common;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {

    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        execute("sequential", () -> bestPriceFinder.findPricesSequential("iphone"));
        execute("parallel", () -> bestPriceFinder.findPricesParallel("iphone"));
        execute("composed CompletableFuture", () -> bestPriceFinder.findPricesFuture("iphone"));
    }

    public static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + "ms");
    }
}
