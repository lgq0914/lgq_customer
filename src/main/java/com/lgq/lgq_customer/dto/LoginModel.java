package com.lgq.lgq_customer.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: lgq_customer
 * @description
 * @author: lgq
 * @create: 2020-03-21 17:52
 **/
@ApiModel(value = "登录实体")
@Data
public class LoginModel {

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String passWord;
}
