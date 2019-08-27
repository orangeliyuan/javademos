package per.example.demo.syncdemo;

/**
 * 同一个方法可重入
 */
public class Demo6 {
    private int a = 0;
    public static void main(String[] args) {
        Demo6 demo = new Demo6();
        demo.method1();
    }
    private synchronized void method1() {
        System.out.println("a=" + a);
        if (a == 0) {
            a++;
            method1();
        }
    }
}
