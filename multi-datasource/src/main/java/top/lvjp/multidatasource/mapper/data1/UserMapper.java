package top.lvjp.multidatasource.mapper.data1;

import org.apache.ibatis.annotations.Mapper;
import top.lvjp.multidatasource.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> listAll();

    User getById(Integer id);

    void insert(User user);

    void update(User user);

}
