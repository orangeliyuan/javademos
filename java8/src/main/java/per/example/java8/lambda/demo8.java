package per.example.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class demo8 {

    public static void main(String[] args) {
        // 谓词复合 negate\and\or
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        Predicate<Apple> greenApple = (Apple apple) -> "green".equals(apple.getColor());
        filter(inventory, greenApple).forEach(System.out::println);

        Predicate<Apple> notGreenApple = greenApple.negate();
        filter(inventory, notGreenApple).forEach(System.out::println);

        Predicate<Apple> greenAndHeavyAppleOrRedApple = greenApple
                .and(a->a.getWeight()>150)
                .or(a->"red".equals(a.getColor()));
        filter(inventory, greenAndHeavyAppleOrRedApple).forEach(System.out::println);

        // 函数复合
        //g(f(x))
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        System.out.println(h.apply(1));

        // f(g(x))
        Function<Integer, Integer> h1 = f.compose(g);
        System.out.println(h1.apply(1));

        // 不通的组装流程
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader
                .andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        System.out.println(transformationPipeline.apply("nihao labda baibai"));

        Function<String, String> transformationPipeline1 = addHeader
                .andThen(Letter::addFooter);
        System.out.println(transformationPipeline1.apply("nihao labda baibai"));
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if(p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";
        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }
        public Integer getWeight() {
            return weight;
        }
        public String getColor() {
            return color;
        }
        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }

    public static class Letter{
        public static String addHeader(String text) {
            return "Letter Header " + text;
        }
        public static String addFooter(String text) {
            return text + " Letter Footer";
        }
        public static String checkSpelling(String text) {
            return text.replaceAll("labda", "lambda");
        }
    }
}
