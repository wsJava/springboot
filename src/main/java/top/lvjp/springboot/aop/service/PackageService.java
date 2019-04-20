package top.lvjp.springboot.aop.service;

import org.springframework.stereotype.Service;

/**
 * @author lvjp
 * @date 2019/4/16
 */
@Service
public class PackageService {

    public String test(String s) throws NullPointerException {
        System.out.println("test only String argument");
        throw new NullPointerException("hahahahah");
//        return s;
    }

    public void test(){
        System.out.println("none argument");
    }

}
