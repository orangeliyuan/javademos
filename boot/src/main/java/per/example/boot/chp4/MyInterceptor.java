package per.example.boot.chp4;

public class MyInterceptor implements Interceptor {

    @Override
    public boolean before() {
        System.out.println("...before");
        return true;
    }

    @Override
    public void after() {
        System.out.println("...after");
    }

    @Override
    public Object around(Invocation invocation) throws Exception{
        System.out.println("around before ...");
        Object obj = invocation.proceed();
        System.out.println("around after ...");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("after return ...");
    }

    @Override
    public void afterThrowing() {
        System.out.println("after throw ...");
    }

    @Override
    public boolean userAround() {
        return true;
    }
}
