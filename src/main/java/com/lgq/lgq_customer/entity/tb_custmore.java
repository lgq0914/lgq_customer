package com.lgq.lgq_customer.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName("tb_custmore")
public class tb_custmore implements Serializable {
    /**
     *
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String passWord;

    /**
     *
     */
    @ApiModelProperty(value = "")
    private Date createdAt;

    /**
     *
     */
    @ApiModelProperty(value = "")
    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}

