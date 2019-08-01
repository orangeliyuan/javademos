package per.example.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * API 中已有的函数式接口
 */
public class demo5 {

    public static void main(String[] args) {
        System.out.println(filter(Arrays.asList(1,2,3,4,5), (Integer i)->i >= 3));
        forEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i));
        System.out.println(map(Arrays.asList("lamdba", "in", "action"), (String s)->s.length()));
    }

    // java.util.function.Predicate 接收泛型T对象， 返回boolean
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    // java.util.function.Consumer 接收泛型T对象， 没有返回
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }

    // java.util.function.Function 接口泛型T对象， 返回泛型R对象
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }
}
