package per.example.java8.async.common;

public class Util {

    public static void delay() {
        int delay = 1_000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
