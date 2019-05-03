package top.lvjp.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * @author lvjp
 * @date 2019/4/25
 */
public class BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

//    @TableField(fill = FieldFill.INSERT)
//    private Date createTime;
//
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private Date updateTime;
}
