package per.example.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class demo14 {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brain = new Trader("Brain", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brain, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(alan, 2012, 950)
        );
        // 找出2011 年发生的交易并按交易额排序
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();

        // 交易员都在哪些不同的城市工作过
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        // 查找所有来自于剑桥的交易员，并按姓名排序 xxx
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();

        // 返回所有交易员的姓名字符串，并按字母排序
        // 字符串拼接每次迭代都要建立一个新的String 对象
        String names = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(names);
        //更好的拼接方案
        String names1 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(names1);

        // 有没有交易员是在米兰工作的
        boolean judge = transactions.stream()
//                .filter(t -> "Milan".equals(t.getTrader().getCity()))
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println(judge);

        // 打印生活在剑桥的交易员的所有交易额
        int sum = transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println(sum);

        // 所有交易中，最高的交易额是多少
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Comparator.comparingInt(t -> t));
        max.ifPresent(System.out::println);

        Optional<Integer> max1 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        // 找到交易额最小的交易
        Optional<Integer> min = transactions.stream()
                .map(Transaction::getValue)
                .min(Comparator.comparing(t -> t));
        min.ifPresent(System.out::println);

        Optional<Transaction> min1 = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
    }
}

class Trader {
    private final String name;
    private final String city;
    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader() {
        return trader;
    }
    public int getYear() {
        return year;
    }
    public int getValue() {
        return value;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
