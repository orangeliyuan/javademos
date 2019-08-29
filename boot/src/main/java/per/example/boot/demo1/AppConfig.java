package per.example.boot.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "AppConfig1")
public class AppConfig {

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setUsername("pipi");
        user.setNote("xxx");
        return user;
    }
}
