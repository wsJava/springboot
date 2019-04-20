package top.lvjp.springboot.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lvjp
 * @date 2019/4/16
 */
@Aspect
@Component
public class PackageAspect {

    @Pointcut("within(top.lvjp.springboot.aop.service.PackageService)")
    public void withinPoint(){}


    @Before("withinPoint()")
    public void before(){
        System.out.println("==============do before all method of service package=============");
    }

}
