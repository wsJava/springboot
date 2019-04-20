package top.lvjp.mongodb.dao.impl;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import top.lvjp.mongodb.dao.UserDao;
import top.lvjp.mongodb.entity.User;

import javax.annotation.Resource;

@Component
public class UserDaoImpl implements UserDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public User insertUser(User user) {
        return mongoTemplate.save(user);
    }

    @Override
    public long removeUser(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.remove(query, User.class).getDeletedCount();
    }

    @Override
    public void updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update();
        update.set("username", user.getUsername());
        update.set("password", user.getPassword());
        // 更新 查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, User.class);
        // 更新查询返回结果集的全部, 并返回修改的数量; 注: 若更新前后未发生变化, 则返回0;
//        mongoTemplate.updateMulti(query, update, User.class).getModifiedCount();
    }

    @Override
    public User getUserById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }
}
