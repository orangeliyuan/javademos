package per.example.boot.chp4;

public interface Interceptor {
    boolean before();
    void after();
    Object around(Invocation invocation) throws Exception;
    void afterReturning();
    void afterThrowing();
    boolean userAround();
}
