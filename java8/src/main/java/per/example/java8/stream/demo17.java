package per.example.java8.stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.BinaryOperator;
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

        // max()
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
        Dish dish1 = Dish.menu.stream().collect(Collectors.reducing(moreCaloricOf)).get();
        System.out.println(dish1);

        // sum
        int sum = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sum);

        // avg
        double avg = Dish.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(avg);

        // summary
        IntSummaryStatistics summary = Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(summary.getMax() + ", " + summary.getAverage() + ", " + summary.getCount() + ", " +
                 "" + summary.getSum());

        // xxx
        String menu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(menu);

        String menu1 = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(menu1);
    }
}
