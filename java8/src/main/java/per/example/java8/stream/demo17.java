package per.example.java8.stream;

import java.util.stream.Collectors;

public class demo17 {

    public static void main(String[] args) {
        // count()
        long count = Dish.menu.stream().collect(Collectors.counting());
        System.out.println(count);

        // max()
        Dish dish = Dish.menu.stream().collect(Collectors.reducing(
                (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2
        )).get();
        System.out.println(dish);
    }
}
