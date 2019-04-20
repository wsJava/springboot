package top.lvjp.springboot.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lvjp.springboot.aop.service.AnnotationService;
import top.lvjp.springboot.aop.service.ObjectService;
import top.lvjp.springboot.aop.service.PackageService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopTest {

    @Autowired
    private PackageService packageService;

    @Autowired
    private ObjectService objectService;

    @Autowired
    private AnnotationService annotationService;

    @Test
    public void test1() throws InterruptedException {


//        annotationService.divideByLocationOperator();
//
//        annotationService.divideByUsualOperator();
        packageService.test("");
//
//        objectService.f("");
    }
}