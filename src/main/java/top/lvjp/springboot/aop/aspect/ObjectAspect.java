package top.lvjp.springboot.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lvjp
 * @date 2019/4/17
 */
@Aspect
@Component
public class ObjectAspect {

    @Pointcut("this(top.lvjp.springboot.aop.service.ObjectService)")
    public void thisPoint(){}

    @Pointcut("target(top.lvjp.springboot.aop.service.ObjectService)")
    public void targetPoint(){}

    @Pointcut("bean(objectServiceImpl)")
    public void beanPoint(){}

//    @Before("targetPoint()")
//    public void beforeTarget(){
//        System.out.println("============ before target =================");
//    }

//    @Before("thisPoint()")
//    public void beforeThis(){
//        System.out.println("============= before this =================");
//    }

    @Before("beanPoint()")
    public void beforeBean(){
        System.out.println("=============== before bean ==============");
    }
}
