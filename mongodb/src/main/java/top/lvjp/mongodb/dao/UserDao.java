package top.lvjp.mongodb.dao;

import top.lvjp.mongodb.entity.User;

import java.util.ArrayList;

public interface UserDao {

    User insertUser(User user);

    long removeUser(Integer id);

    /**
     * 更新 User
     * @param user
     */
    void updateUser(User user);

    User getUserById(Integer id);
}
