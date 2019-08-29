package per.example.boot.demo2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanProcessorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器postProcessBeforeInitialization("+ bean.getClass().getSimpleName() + "," + beanName +")");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器postProcessAfterInitialization("+ bean.getClass().getSimpleName() + "," + beanName +")");
        return bean;
    }
}
