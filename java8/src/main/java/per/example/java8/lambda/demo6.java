package per.example.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class demo6 {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")));

        inventory.sort(new AppleComparator());
        System.out.println(inventory);
        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]

        inventory.set(1, new Apple(30, "green"));
        System.out.println(inventory);
        // [Apple{color='green', weight=80}, Apple{color='green', weight=30}, Apple{color='green', weight=155}]
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(inventory);
        // [Apple{color='green', weight=30}, Apple{color='green', weight=80}, Apple{color='green', weight=155}]

        inventory.set(1, new Apple(20, "red"));
        System.out.println(inventory);
        // [Apple{color='green', weight=30}, Apple{color='red', weight=20}, Apple{color='green', weight=155}]
        inventory.sort(((o1, o2) -> o1.getWeight().compareTo(o2.getWeight())));
        System.out.println(inventory);
        // [Apple{color='red', weight=20}, Apple{color='green', weight=30}, Apple{color='green', weight=155}]

        inventory.set(1, new Apple(10, "green"));
        System.out.println(inventory);
        // [Apple{color='red', weight=20}, Apple{color='green', weight=10}, Apple{color='green', weight=155}]
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
        // [Apple{color='green', weight=10}, Apple{color='red', weight=20}, Apple{color='green', weight=155}]
    }

    public static class Apple {
        private Integer weight = 0;
        private String color = "";
        public Apple(Integer weight, String color){
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

    static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }
}
