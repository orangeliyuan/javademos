package per.example.boot.chp4.demo2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @DeclareParents(
            value = "per.example.boot.chp4.demo2.UserServiceImpl+",
            defaultImpl = UserValidatorImpl.class
    )
    public UserValidator userValidator;
}
