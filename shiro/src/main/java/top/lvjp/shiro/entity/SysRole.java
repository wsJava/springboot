package top.lvjp.shiro.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class SysRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String role;

    private String description;

    /**
     * 是否可用, 不可用不添加给用户
     */
    private Boolean available = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<SysPermission> permission;

//    @ManyToMany
//    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name  ="uid")})
//    private List<UserInfo> userInfos;
}
