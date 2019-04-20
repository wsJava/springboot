package top.lvjp.shiro.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.rmi.server.UID;
import java.util.List;

@Entity
@Data
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer uid;

    @Column(unique = true)
    private String username;

    private String password;

    private String salt;

    /**
     * 用户状态, 0: 创建未认证, 1: 正常状态, 2: 用户被锁定
     */
    private byte state;

    @ManyToMany(fetch = FetchType.EAGER)        // 立刻从数据库中加载数据
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roleList;
}
