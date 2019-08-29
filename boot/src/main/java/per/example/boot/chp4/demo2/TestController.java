package per.example.boot.chp4.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService userService = null;

    @GetMapping("/vp")
    public void validate(User user){
        UserValidator userValidator = (UserValidator) userService;
        if (userValidator.validate(user)) {
            userService.printUserInfo(user);
        }
    }
}
