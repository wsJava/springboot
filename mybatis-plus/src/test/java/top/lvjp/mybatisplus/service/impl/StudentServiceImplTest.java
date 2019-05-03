package top.lvjp.mybatisplus.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lvjp.mybatisplus.service.IStudentService;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceImplTest {

    @Autowired
    private IStudentService studentService;

    @Test
    public void contextLoads() {
        studentService.test();
    }

}