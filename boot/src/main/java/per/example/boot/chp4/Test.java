package per.example.boot.chp4;

public class Test {

    public static void main(String[] args) {
        HelloService service = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(service, new MyInterceptor());
        proxy.sayHello("pipi");
    }
}
