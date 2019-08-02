package per.example.java8.stream;

import java.util.stream.Collectors;

public class demo18 {
    public static void main(String[] args) {
        int totalCalories = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j)-> i + j));
        System.out.println(totalCalories);

        int totalCalories1 = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(totalCalories1);

        Dish.menu.stream().map(Dish::getCalories).collect(Collectors.reducing(Integer::sum)).ifPresent(i -> System.out.println(i));

        int totalCalories2 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(totalCalories2);
    }
}
