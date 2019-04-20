package top.lvjp.springboot.aop.service.impl;

import org.springframework.stereotype.Service;
import top.lvjp.springboot.aop.annotation.TimeSpan;
import top.lvjp.springboot.aop.service.AnnotationService;

/**
 * @author lvjp
 * @date 2019/4/17
 */
@Service
public class AnnotationServiceImpl implements AnnotationService {

    @Override
    @TimeSpan
    public Integer divideByLocationOperator() {
        int i = 1234567890;
        int j = i >> 4;
        return j;
    }

    @Override
    @TimeSpan
    public Integer divideByUsualOperator() {
        int i = 1233333333;
        int j = i / 16;
        return j;
    }
}
