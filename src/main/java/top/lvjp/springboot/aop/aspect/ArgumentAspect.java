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
public class ArgumentAspect {

    // 注: 不能只使用 args, 必须和其他表达式配合指定具体某个范围的方法, 不然 cglib 不能生成动态代理类
    @Pointcut("within(top.lvjp.springboot.aop..*) &&args(String)")
    public void argsPoint(){}

    @Before("argsPoint()")
    public void beforeArgs(){
        System.out.println("=========== before args ================");
    }
}
