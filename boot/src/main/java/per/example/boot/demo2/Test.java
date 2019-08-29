package per.example.boot.demo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BussinessPerson person = context.getBean(BussinessPerson.class);
        person.service();
        context.close();
    }
}
