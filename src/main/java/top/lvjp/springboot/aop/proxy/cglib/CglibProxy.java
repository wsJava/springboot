package top.lvjp.springboot.aop.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lvjp
 * @date 2019/4/17
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("------------- before");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.printf("-------------- after");
        return result;
    }
}
