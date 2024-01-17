package org.simple.sm.db.sqlite.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * @since 2024-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TBarkInfo implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String jobNo;

    private String barkNo;

    private String client;

    private String url;

    private String type;

      @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

      @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @TableLogic
    private Integer isDelete;


}
