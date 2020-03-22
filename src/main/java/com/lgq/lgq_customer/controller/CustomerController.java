package com.lgq.lgq_customer.controller;

import com.lgq.lgq_customer.config.WebApiResult;
import com.lgq.lgq_customer.constants.CustomerEnum;
import com.lgq.lgq_customer.constants.LoginEnum;
import com.lgq.lgq_customer.dto.DtoCustmore;
import com.lgq.lgq_customer.dto.LoginModel;
import com.lgq.lgq_customer.entity.tb_custmore;
import com.lgq.lgq_customer.interfaces.ICustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @program: lgq_customer
 * @description
 * @author: lgq
 * @create: 2020-03-21 15:24
 **/
@Slf4j
@Api(tags = "用户管理")
@RequestMapping("/customerApi")
@RestController
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    /**
     * 用户注册、新建用户
     * @param dtoCustmore
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public WebApiResult<Boolean> createCustomer(@RequestBody DtoCustmore dtoCustmore) {
        WebApiResult<Boolean> result = new WebApiResult<>();
        try {
            log.info("[客户]-[用户注册]-请求参数：{}", dtoCustmore);
            if(dtoCustmore == null){
                throw new Exception("请求参数为空");
            }
            String code = customerService.createCustomer(dtoCustmore);
            if(CustomerEnum.Success.getCode().equals(code)){
                result.setData(true);
                result.setMessage("注册成功");
            }else{
                result.setData(false);
                result.setMessage("注册失败");
            }
            result.setCode(code);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(String.format("用户注册失败, 原因:%s %n %s", e.getMessage(), Arrays.toString(e.getStackTrace())));
            result.setMessage("用户注册失败!"+e.getMessage());
            result.setData(false);
        }
        return result;
    }

    /**
     * 用户登录
     * @param loginModel
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public WebApiResult<Boolean> login(@RequestBody LoginModel loginModel) {
        WebApiResult<Boolean> result = new WebApiResult<>();
        try {
            log.info("[客户]-[用户登录]-请求参数：{}", loginModel);
            if(loginModel == null){
                throw new Exception("请求参数为空");
            }
            String code = customerService.login(loginModel);
            if(LoginEnum.Success.getCode().equals(code)){
                result.setData(true);
                result.setMessage("登陆成功");
            }else{
                result.setData(false);
                result.setMessage("登陆失败");
            }
            result.setCode(code);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(String.format("用户登录失败, 原因:%s %n %s", e.getMessage(), Arrays.toString(e.getStackTrace())));
            result.setMessage("用户登录失败!"+e.getMessage());
            result.setData(false);
        }
        return result;
    }
}
