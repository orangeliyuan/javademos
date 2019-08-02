package per.example.java8.stream;

import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class demo20 {

    public static void main(String[] args) {
        Map<Boolean, List<Dish>> map1 = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(map1);

        Map<Boolean, Map<Dish.Type, List<Dish>>> map2 = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(map2);

        Map<Boolean, Dish> map3 = Dish.menu.stream().collect(
                partitioningBy(
                        Dish::isVegetarian,
                        collectingAndThen(
                                maxBy(Comparator.comparing(Dish::getCalories)),
                                Optional::get
                        )
                )
        );
        System.out.println(map3);
    }
}
