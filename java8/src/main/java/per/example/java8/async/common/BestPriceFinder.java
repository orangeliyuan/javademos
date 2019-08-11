package per.example.java8.async.common;

import com.sun.xml.internal.ws.util.CompletedFuture;
import per.example.java8.async.v1.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(
            new Shop("iphone"),
            new Shop("xiaomi"),
            new Shop("huawei"),
            new Shop("oppo")
    );

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });
    // 一般方法
    public List<String> findPricesSequential(String product) {
        return shops.stream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(toList());
    }
    // 使用并行流
    public List<String> findPricesParallel(String product) {
        return shops.parallelStream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(toList());
    }
    // 使用CompletableFuture
    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutrues = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is "
                        + shop.getPrice(product), executor))
                .collect(toList());
        List<String> prices = priceFutrues.stream()
                .map(CompletableFuture::join)
                .collect(toList());
        return prices;
    }
}
