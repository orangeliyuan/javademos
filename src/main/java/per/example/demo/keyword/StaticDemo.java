package per.example.demo.keyword;

public class StaticDemo {
    Person p = new Person("demo");
    static {
        System.out.println("demo static");
    }
    public StaticDemo() {
        System.out.println("demo constructor");
    }
    public static void main(String[] args) {
        new Test();
    }
}
class Test extends StaticDemo {
    Person p = new Person("test");
    static {
        System.out.println("test static");
    }
    public Test() {
        System.out.println("test constructor");
    }
}
class Person {
    static {
        System.out.println("person static");
    }
    public Person(String str) {
        System.out.println("person " + str);
    }
}