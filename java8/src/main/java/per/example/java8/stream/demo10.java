package per.example.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo10 {

    public static void main(String[] args) {
        List<Dish> vegetarianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        vegetarianMenu.forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1,2,3,1,1,1,2,3,4,3,4,2);
        numbers.stream().filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        List<Dish> limitExa = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        limitExa.forEach(System.out::println);
        
        List<Dish> skipExa = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        skipExa.forEach(System.out::println);
    }
}
