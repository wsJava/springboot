package top.lvjp.springboot.aop.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author lvjp
 * @date 2019/4/17
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetService.class);
        enhancer.setCallback(new CglibProxy());
        TargetService service = (TargetService) enhancer.create();
        service.save();
    }
}
