package per.example.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 上一个demo 介绍了传递方法，但是这种一次性的简短方法定义
 * 比较浪费时间, 所以传递的简短方法用lamdba 代替比较简洁，
 * 如果这个方法比较长/复杂，那么用之前的方式代码就更加清晰
 */
public class demo3 {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        filterApples(inventory, (Apple a) -> "green".equals(a.getColor())).forEach(value-> System.out.println(value));
        filterApples(inventory, (Apple a) -> a.getWeight() > 150).forEach(value-> System.out.println(value));

        filter(inventory, new ApplePredicate()).forEach(value-> System.out.println(value));
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
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
    }

    // --------------
    public interface Predicate<T> {
        boolean test(T t);
    }

    static class ApplePredicate implements Predicate<Apple> {
        public boolean test(Apple apple) {
            return apple.getWeight() > 150 && "green".equals(apple.getColor());
        }
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
}
