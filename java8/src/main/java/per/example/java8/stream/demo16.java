package per.example.java8.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class demo16 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("java 8", "is", "so", "good");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();

        int[] numbers = {2,3,5,7,11,13};
        System.out.println(Arrays.stream(numbers).sum());

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println(t[0]+", "+t[1]));

        System.out.println("---");
        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        IntStream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);

        try {
            long uniqueWords = Files.lines(Paths.get("C:/Users/liyuan/Desktop/temp1.txt"), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println(uniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
