package per.example.java8.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class demo21 {

    public static void main(String[] args) {
        long fastest = Long.MAX_VALUE;
        long duration = 0;
        Map<Boolean, List<Integer>> map1 = null;
        Map<Boolean, List<Integer>> map2 = null;

        for (int x = 0; x < 10; x++) {
            long start = System.nanoTime();
            map1 = IntStream.rangeClosed(2, 100).boxed()
                .collect(partitioningBy(t -> {
                    return IntStream.rangeClosed(2, t - 1)
                            .limit((long) Math.floor(Math.sqrt((double) t)) - 1)
                            .noneMatch(i -> t % i == 0);
                }));
            duration += (System.nanoTime() - start);
        }
        System.out.println(duration / 10);
        System.out.println(map1);

        duration = 0;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            map2 = IntStream.rangeClosed(2, 100).boxed()
                .collect(new PrimeNumbersCollector());
            duration += (System.nanoTime() - start);
        }

        System.out.println(duration / 10);
        System.out.println(map2);
    }

    public static class PrimeNumbersCollector implements
            Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
        @Override
        public Supplier<Map<Boolean, List<Integer>>> supplier() {
            return () -> new HashMap<Boolean, List<Integer>>() {{
                put(true, new ArrayList<>());
                put(false, new ArrayList<>());
            }};
        }

        @Override
        public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
            return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
                acc.get(isPrime(candidate)).add(candidate);
            };
        }

        private boolean isPrime(int candidate) {
            if (candidate == 2 || candidate == 3) { return true; }
            if (candidate % 6 != 1 && candidate % 6 != 5) { return false; }
            int lim = (int) Math.floor(Math.sqrt(candidate));
            for (int i = 5; i <= lim; i += 6) {
                if (candidate % i == 0 || candidate % (i+2) == 0) { return false; }
            }
            return true;
        }

        @Override
        public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
            return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
                map1.get(true).addAll(map2.get(true));
                map1.get(false).addAll(map2.get(false));
                return map1;
            };
        }

        @Override
        public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
            return i -> i;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(
                    Characteristics.IDENTITY_FINISH
            ));
        }
    }

}
