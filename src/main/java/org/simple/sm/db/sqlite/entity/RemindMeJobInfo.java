package org.simple.sm.db.sqlite.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author newbiebo
 * @since 2023-06-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RemindMeJobInfo implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String jobNo;

    private String jobName;

    private String jobGroup;

    private String expression;

    private String key;

    private String url;

    private String client;

    @TableLogic
    private Integer isDelete;

    private String gmtCerate;

    private String gmtModofied;


}
