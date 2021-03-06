package per.example.demo.syncdemo;

public class Demo3 implements Runnable{
    private static Demo3 instance = new Demo3();
    @Override
    public void run() {
        method();
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
    private synchronized void method() {
        System.out.println("方法锁：线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " done");
    }
}
