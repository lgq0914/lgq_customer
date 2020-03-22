package com.lgq.lgq_customer.interfaces;

import com.lgq.lgq_customer.dto.DtoCustmore;
import com.lgq.lgq_customer.dto.LoginModel;
import com.lgq.lgq_customer.entity.tb_custmore;

/**
 * @program: lgq_customer
 * @description
 * @author: lgq
 * @create: 2020-03-21 15:23
 **/
public interface ICustomerService {

    /**
     * 新建用户
     * @param dtoCustmore
     * @return
     */
    String createCustomer(DtoCustmore dtoCustmore) throws Exception;

    /**
     * 用户登录
     * @param loginModel
     * @return
     */
    String login(LoginModel loginModel) throws Exception;
}
