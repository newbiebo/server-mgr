package org.simple.sm.db.sqlite.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author newbiebo
 * @since 2023-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TQuartzInfo implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String jobNo;

    private String jobName;

    private String jobGroup;

    private String expression;

    private String status;

    @TableLogic
    private Integer isDelete;

      @TableField(fill = FieldFill.INSERT)
    private String gmtCreate;

      @TableField(fill = FieldFill.INSERT_UPDATE)
    private String gmtModified;


}
