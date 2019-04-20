package top.lvjp.mongodb.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lvjp.mongodb.entity.User;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void insertUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("root");
        user.setPassword("123456");
        User inserted = userDao.insertUser(user);
        Assert.assertEquals("root", inserted.getUsername());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("root");
        user.setPassword("root");
        long count = userDao.updateUser(user);
        Assert.assertEquals(1, count);
    }

    @Test
    public void getUserById() {
        User user = userDao.getUserById(1);
        Assert.assertEquals("root", user.getUsername());

    }

    @Test
    public void removeUser() {
        long count = userDao.removeUser(1);
        Assert.assertEquals(1, count);
    }
}