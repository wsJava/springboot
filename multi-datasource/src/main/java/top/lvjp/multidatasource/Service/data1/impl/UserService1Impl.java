package top.lvjp.multidatasource.Service.data1.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lvjp.multidatasource.Service.data1.UserService1;
import top.lvjp.multidatasource.entity.User;
import top.lvjp.multidatasource.mapper.data1.UserMapper;

import java.util.List;

@Service
public class UserService1Impl implements UserService1 {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }
}
