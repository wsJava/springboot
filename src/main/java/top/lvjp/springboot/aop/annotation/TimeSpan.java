package top.lvjp.springboot.aop.annotation;


import java.lang.annotation.*;

/**
 * 记录方法的执行时间跨度
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimeSpan {
}
