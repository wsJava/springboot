package top.lvjp.multidatasource.Service.data1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserService1Test {

    @Autowired
    private UserService1 userService1;

    @Test
    public void listAll() {
        System.out.println(userService1.listAll().get(0).toString());
    }
}