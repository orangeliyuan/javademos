package per.example.boot.demo2;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal{
    @Override
    public void user() {
        System.out.println("汪汪汪");
    }
}
