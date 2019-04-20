package top.lvjp.shiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.lvjp.shiro.entity.UserInfo;

public interface UserRepository  extends JpaRepository<UserInfo, Integer> {

    UserInfo findByUsername(String username);
}
