package per.example.java8.program;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class demo26 {

    public static void main(String[] args) {
        // 不是用lambda(链表)
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("labda is good");
        System.out.println(result);

        // 使用lambda
        UnaryOperator<String> headerProcessing = (String text) -> "hello pipi : " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        String result1 = headerProcessing.apply("labda is so good");
        System.out.println(result1);
    }

    static private abstract class ProcessingObject<T> {
        protected ProcessingObject<T> successor;
        public void setSuccessor(ProcessingObject<T> successor) {
            this.successor = successor;
        }

        public T handle(T input) {
            T r = handleWork(input);
            if (successor != null) {
                return successor.handle(r);
            }
            return r;
        }
        abstract protected T handleWork(T input);
    }

    static private class HeaderTextProcessing extends ProcessingObject<String> {
        @Override
        protected String handleWork(String text) {
            return "hello pipi: " + text;
        }
    }
    static private class SpellCheckerProcessing extends ProcessingObject<String> {
        @Override
        protected String handleWork(String text) {
            return text.replaceAll("labda", "lambda");
        }
    }
}
