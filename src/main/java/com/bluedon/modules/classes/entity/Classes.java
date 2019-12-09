package com.bluedon.modules.classes.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hhong
 * @since 2019-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_classes")
public class Classes extends Model<Classes> {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String className;

    private String classNo;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
