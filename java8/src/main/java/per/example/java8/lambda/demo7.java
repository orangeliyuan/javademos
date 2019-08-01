package per.example.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class demo7 {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("a", "b", "A", "B");
//        str.sort((s1, s2)->s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);

//        Supplier<Apple> c1 = () -> new Apple();
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();
        System.out.println(a1);

//        Function<Integer, Apple> c2 = (Integer weight) -> new Apple(weight);
        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(101);
        System.out.println(a2);

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);

//        BiFunction<String, Integer, Apple> c3 = (String color, Integer weight) -> new Apple(color, weight);
        BiFunction<String, Integer, Apple> c3 = Apple::new;
        Apple a3 = c3.apply("green", 100);
        System.out.println(a3);
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }

    public static class Apple {
        private Integer weight = 0;
        private String color = "";
        public Apple() {}
        public Apple(Integer weight) {
            this.weight = weight;
        }
        public Apple(String color, Integer weight){
            this.weight = weight;
            this.color = color;
        }
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
