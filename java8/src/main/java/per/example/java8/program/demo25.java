package per.example.java8.program;

import java.util.ArrayList;
import java.util.List;

public class demo25 {

    public static void main(String[] args) {
        // 不使用lambda
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());
        feed.notifyObserver("queen money");

        // 使用lambda
        Feed feedLambda = new Feed();
        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("ny : " + tweet);
            }
        });
        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("yet : " + tweet);
            }
        });
        feedLambda.notifyObserver("queen");
    }

    // 观察者
    interface Observer {
        void inform(String tweet);
    }
    // 主题
    interface Subject {
        void registerObserver(Observer observer);
        void notifyObserver(String tweet);
    }
    // 三个具体的观察者
    static private class NYTimes implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("breaking news in ny! " + tweet);
            }
        }
    }
    static private class Guardian implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("yet another new in london.. " + tweet);
            }
        }
    }
    static private class LeMonde implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("today cheese, wine and news " + tweet);
            }
        }
    }
    // 主题的实现类
    static private class Feed implements Subject {
        private final List<Observer> observers = new ArrayList<>();
        @Override
        public void registerObserver(Observer observer) {
            this.observers.add(observer);
        }
        @Override
        public void notifyObserver(String tweet) {
            observers.forEach(o -> o.inform(tweet));
        }
    }
}
