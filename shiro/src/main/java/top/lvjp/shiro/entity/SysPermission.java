package top.lvjp.shiro.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class SysPermission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType;

    private String url;

    /**
     * 权限字符串, menu 例子: role:*, button 例子: role:create, role:update
     */
    private String permission;

    private Long parentId;

    private String parentIds;

    private Boolean available = Boolean.FALSE;

//    @ManyToMany
//    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
//    private List<SysRole> roles;

}
