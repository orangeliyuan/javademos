package per.example.boot.chp4.demo2;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUserInfo(User user) {
        if (user != null) {
            System.out.println(user.getName() + " " + user.getNote());
        }
    }
}
