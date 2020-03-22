package com.lgq.lgq_customer.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lgq.lgq_customer.constants.CustomerEnum;
import com.lgq.lgq_customer.constants.LoginEnum;
import com.lgq.lgq_customer.dto.DtoCustmore;
import com.lgq.lgq_customer.dto.LoginModel;
import com.lgq.lgq_customer.entity.tb_custmore;
import com.lgq.lgq_customer.interfaces.ICustomerService;
import com.lgq.lgq_customer.mapper.TbCustmoreMapper;
import com.lgq.lgq_customer.utils.DaoToDtoUtilsForCustomer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: lgq_customer
 * @description
 * @author: lgq
 * @create: 2020-03-21 15:23
 **/
@Slf4j
@Component
public class CustomerService extends ServiceImpl<TbCustmoreMapper, tb_custmore> implements ICustomerService {

    @Autowired
    TbCustmoreMapper tbCustmoreMapper;

    /**
     * 新建用户
     *
     * @param dtoCustmore
     * @return
     */
    @Override
    public String createCustomer(DtoCustmore dtoCustmore) throws Exception {
        try {
            log.info("[客户]-[新建客户]-开始");

            tb_custmore tb_custmore = DaoToDtoUtilsForCustomer.INSTANCES.toTbCustomer(dtoCustmore);

            String phone = tb_custmore.getPhone();

            if (phone.length() != 11) {
                return CustomerEnum.InValid.getCode();
            }

            String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean matches = m.matches();
            if (!matches) {
                return CustomerEnum.InValid.getCode();
            }

            Wrapper<tb_custmore> wrapper = new EntityWrapper<>();
            wrapper.eq("Phone", phone);
            Integer count = tbCustmoreMapper.selectCount(wrapper);
            if (count != 0) {
                return CustomerEnum.Repetition.getCode();
            }

            String passWord = tb_custmore.getPassWord();
            if (passWord.length() < 6 || passWord.length() > 18) {
                return CustomerEnum.PassWordInValid.getCode();
            }

            tb_custmore.setId(UUID.randomUUID().toString());
            tb_custmore.setPassWord(SecureUtil.md5(passWord));
            tb_custmore.setCreatedAt(new Date());
            tb_custmore.setDeleted(false);
            Integer ok = tbCustmoreMapper.insert(tb_custmore);
            if(ok == 1){
                return CustomerEnum.Success.getCode();
            }else{
                return CustomerEnum.Exception.getCode();
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("[客户]-[新建客户]-异常!" + e.getMessage());
            throw e;
        }
    }

    /**
     * 用户登录
     *
     * @param loginModel
     * @return
     */
    @Override
    public String login(LoginModel loginModel) throws Exception {
        try {
            log.info("[客户]-[用户登录]-开始");

            String phone = loginModel.getPhone();
            String passWord = loginModel.getPassWord();

            Wrapper<tb_custmore> wrapper = new EntityWrapper<>();
            wrapper.eq("Phone", phone);
            Integer count = tbCustmoreMapper.selectCount(wrapper);
            if (count == 0) {
                return LoginEnum.NotRegister.getCode();
            }

            wrapper.eq("PassWord", SecureUtil.md5(passWord));
            count = tbCustmoreMapper.selectCount(wrapper);
            if (count == 0) {
                return LoginEnum.PassWordWrong.getCode();
            }

            return LoginEnum.Success.getCode();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("[客户]-[用户登录]-异常!" + e.getMessage());
            throw e;
        }
    }




}
