package top.lvjp.springboot.aop.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author lvjp
 * @date 2019/4/17
 */
public class JdkProxyTest {

    public static void main(String[] args) {

        Service service = new TargetService();
        JdkProxy jdkProxy = new JdkProxy(service);

        Service serviceProxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(), jdkProxy);
        serviceProxy.save();
    }
}
