package top.lvjp.springboot.aop.service;

/**
 * @author lvjp
 * @date 2019/4/17
 */
public interface AnnotationService {

    Integer divideByLocationOperator();

    Integer divideByUsualOperator() throws InterruptedException;
}
