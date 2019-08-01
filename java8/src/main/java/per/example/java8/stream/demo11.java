package per.example.java8.stream;

import java.util.Optional;

public class demo11 {

    public static void main(String[] args) {
        System.out.println(Dish.menu.stream().anyMatch(Dish::isVegetarian) ? "有素菜" : "没");

        System.out.println(Dish.menu.stream().allMatch(d -> d.getCalories() < 1000) ? "全部小于1000卡路里" : "...");

        System.out.println(Dish.menu.stream().noneMatch(d -> d.getCalories() >= 1000) ? "全部小于1000卡路里" : "...");

        Optional<Dish> dish = Dish.menu.stream().filter(Dish::isVegetarian).findAny();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }
}
