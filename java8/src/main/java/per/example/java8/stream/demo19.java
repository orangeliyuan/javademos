package per.example.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class demo19 {

    enum CaloricLevel {DIET, NORMAL, FAT};

    public static void main(String[] args) {
        // 按菜的类型分组
        Map<Dish.Type, List<Dish>> map1 = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(map1);

        // 按菜的类型分组，并将map value 取为菜名
        Map<Dish.Type, List<String>> map2 = Dish.menu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        System.out.println(map2);

        // 按热量分组
        Map<CaloricLevel, List<Dish>> map3 = Dish.menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {return CaloricLevel.DIET;}
                    else if (dish.getCalories() <= 700) {return CaloricLevel.NORMAL;}
                    else {return CaloricLevel.FAT;}
                }));
        System.out.println(map3);

        // 菜类型一级分组， 热量二级分组
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> map4 = Dish.menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy((Dish dish) -> {
                            if (dish.getCalories() <= 400) {return CaloricLevel.DIET;}
                            else if (dish.getCalories() <=700) {return CaloricLevel.NORMAL;}
                            else {return CaloricLevel.FAT;}
                        })
                )
        );
        System.out.println(map4);

        // 菜数量分组
        Map<Dish.Type, Long> map5 = Dish.menu.stream().collect(groupingBy(
                Dish::getType, counting()));
        System.out.println(map5);

        // 按菜类型分组，value 取热量最高的
        Map<Dish.Type, Optional<Dish>> map6 = Dish.menu.stream().collect(groupingBy(
                Dish::getType,
                reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)
        ));
        System.out.println(map6);

        // 同上， 进行了类型转换
        Map<Dish.Type, Dish> map7 = Dish.menu.stream().collect(groupingBy(
                Dish::getType,
                collectingAndThen(
                        reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2),
                        Optional::get
                )
        ));
        System.out.println(map7);

        // 按类型筛选菜数量
        Map<Dish.Type, Integer> map8 = Dish.menu.stream().collect(groupingBy(
                Dish::getType,
                summingInt(Dish::getCalories)
        ));
        System.out.println(map8);

        // 按类型， 并将类型中拥有的热量程度映射出来
        Map<Dish.Type, Set<CaloricLevel>> map9 = Dish.menu.stream().collect(groupingBy(
                Dish::getType,
                mapping(dish -> {
                    if (dish.getCalories() <=400) { return CaloricLevel.DIET; }
                    else if (dish.getCalories() <= 700) { return CaloricLevel.NORMAL; }
                    else { return CaloricLevel.FAT; }
                }, toSet())
        ));
        System.out.println(map9);
    }
}
