package top.lvjp.springboot.aop.service.impl;

import org.springframework.stereotype.Service;
import top.lvjp.springboot.aop.annotation.TimeSpan;
import top.lvjp.springboot.aop.service.ObjectService;

/**
 * @author lvjp
 * @date 2019/4/17
 */
@Service
public class ObjectServiceImpl implements ObjectService {

    @Override
    public void f() {
        System.out.println("========== ObjectServiceImpl f() =========");
    }

    @Override
    public String f(String s) {
        System.out.println("========= objectserviceimpl f(String)============");
        return s;
    }
}
