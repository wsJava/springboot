package top.lvjp.springboot.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lvjp
 * @date 2019/4/17
 */
@Aspect
@Component
public class AnnotationAspect {

    private static final ConcurrentHashMap<Signature, Long> BEGIN_TIME_MAP = new ConcurrentHashMap<>(16);

    @Pointcut("@annotation(top.lvjp.springboot.aop.annotation.TimeSpan) && within(top.lvjp.springboot.aop..*))")
    public void annotationPoint(){}

    @Before("annotationPoint()")
    public void start(JoinPoint joinPoint){
//        System.out.println(joinPoint.getSignature().getName() + "  begin  " + System.currentTimeMillis());
        BEGIN_TIME_MAP.put(joinPoint.getSignature(), System.currentTimeMillis());
    }

    @After("annotationPoint()")
    public void finish(JoinPoint joinPoint){
//        System.out.println(joinPoint.getSignature().getName() + "  end  " + System.currentTimeMillis());
        Long start = BEGIN_TIME_MAP.get(joinPoint.getSignature());
        BEGIN_TIME_MAP.remove(joinPoint.getSignature());
        Long span = System.currentTimeMillis() - start;
        String method = joinPoint.getSignature().getName();
        System.out.println("the " + method + " methed span time " + span + " milliseconds");
    }

}
