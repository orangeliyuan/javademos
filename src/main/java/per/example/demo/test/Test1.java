package per.example.demo.test;

public class Test1 {

    public boolean isJO(int num) {
        return (num & 1) == 0;
    }

    public static void main(String[] args) {
        int num = 2;
        System.out.println(num & 1);
    }
}
