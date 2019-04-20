package top.lvjp.springboot.aop.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lvjp
 * @date 2019/4/17
 */
@Aspect
@Component
public class ExecutionAspect {

    // 匹配 top.lvjp.springboot.aop.service 包及子包下所有公有方法
    @Pointcut("execution(public * top.lvjp.springboot.aop.service.*.*(..))")
    public void allPublic(){}

    // 匹配所有返回值为String的方法
    @Pointcut("execution(String top.lvjp.springboot.aop.service..*(..))")
    public void allString(){}

    @Pointcut("execution(public * top.lvjp.springboot.aop.service..*(..) throws NullPointerException)")
    public void matchException(){}

    @AfterReturning(value = "allPublic()", returning = "result")
    public void afterReturning(Object result){
        System.out.println("======== return : " + result.toString());
    }

    @AfterReturning(value = "allString()", returning = "result")
    public void afterString(Object result){
        System.out.println("======== return : " + result.toString());
    }

    @AfterThrowing(value = "matchException()", throwing = "e")
    public void afterThrowing(NullPointerException e){
        System.out.println("find a  nullPointerException  " + e.getMessage());
    }
}
