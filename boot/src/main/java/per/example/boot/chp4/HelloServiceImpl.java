package per.example.boot.chp4;

import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

@Service
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello(String name) {
        System.out.println("hello:" + name);
    }
}
