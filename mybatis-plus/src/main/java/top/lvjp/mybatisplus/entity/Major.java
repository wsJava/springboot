package top.lvjp.mybatisplus.entity;

import top.lvjp.mybatisplus.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lvjp
 * @since 2019-04-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Major extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String academy;

    private String major;

}
