package per.example.java8.program;

import java.util.function.Consumer;

public class demo24 {

    public static void main(String[] args) {
        new demo24().processCustomer(1234, (Customer c) -> System.out.println("hello"));
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    static private class Customer {}

    static private class Database {
        static Customer getCustomerWithId(int id) {return new Customer();}
    }
}

// 不是用lambda
abstract class OnlineBanking {
    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }
    abstract void makeCustomerHappy(Customer c);

    static class Customer {}
    static private class Database {
        static Customer getCustomerWithId(int id) {return new Customer();}
    }
}

class Test extends OnlineBanking {
    @Override
    void makeCustomerHappy(OnlineBanking.Customer c) {
        System.out.println("xxx");
    }
}
