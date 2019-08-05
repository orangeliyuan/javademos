package per.example.java8.program;

public class demo23 {

    public static void main(String[] args) {
        // 不使用 lambda
        Validator v1 = new Validator(new IsNumeric());
        System.out.println(v1.validate("aaaa"));
        Validator v2 = new Validator(new IsAllLowerCase());
        System.out.println(v2.validate("bbb"));

        // 使用 lambda
        Validator v3 = new Validator((String s) -> s.matches("\\d+"));
        System.out.println(v3.validate("aaaa"));
        Validator v4 = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(v4.validate("bbbb"));
    }

    // 验证策略函数式接口(String->boolean) 以及具体的实现类
    @FunctionalInterface
    interface ValidationStrategy {
        boolean execute(String s);
    }
    static private class IsAllLowerCase implements ValidationStrategy {
        @Override
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }
    static private class IsNumeric implements ValidationStrategy {
        @Override
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }

    // 验证类
    static private class Validator {
        private final ValidationStrategy strategy;
        public Validator(ValidationStrategy strategy) {
            this.strategy = strategy;
        }
        public boolean validate(String s) {
            return strategy.execute(s);
        }
    }
}
