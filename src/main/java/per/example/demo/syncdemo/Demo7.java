package per.example.demo.syncdemo;

public class Demo7 {
    public static void main(String[] args) {
        Demo7 demo = new Demo7();
        demo.method1();
    }
    private synchronized void method1() {
        System.out.println("method1");
        this.method2();
    }
    private synchronized void method2() {
        System.out.println("method2");
    }
}
