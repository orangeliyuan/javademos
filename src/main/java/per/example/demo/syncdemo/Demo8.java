package per.example.demo.syncdemo;

public class Demo8 {
    protected synchronized void method() {
        System.out.println("我是爹");
    }
}
class Test extends Demo8 {
    @Override
    protected synchronized void method() {
        super.method();
        System.out.println("我是儿子");
    }
    public static void main(String[] args) {
        Test t = new Test();
        t.method();
    }
}
