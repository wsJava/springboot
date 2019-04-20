package top.lvjp.springboot.aop.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lvjp
 * @date 2019/4/17
 */
public class JdkProxy implements InvocationHandler {

    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------- before invoke ----------");
        Object result = method.invoke(target, args);
        System.out.println("--------- after invoke -----------");
        return result;
    }
}
