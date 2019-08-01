package per.example.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 这个例子通过筛选苹果来举例java8 传递方法的方式
 */
public class demo2 {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

//        filterGreenApples(inventory).forEach(value->System.out.println(value.getColor()));

//        filterHeavyApples(inventory).forEach(value-> System.out.println(value.getWeight()));

        filterApples(inventory, demo2::isGreenApple).forEach(value-> System.out.println(value.getColor()));

        filterApples(inventory, demo2::isHeavyApple).forEach(value-> System.out.println(value.getWeight()));;

        filterApples(inventory, (Apple apple)-> apple.getWeight() > 150).forEach(value-> System.out.println(value.getWeight()));
    }

    // 选绿色的苹果
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // 选超过150g的苹果， 和上一段代码非常相似
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
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
}
