package com.lgq.lgq_customer.config;

import lombok.Data;

import java.util.ArrayList;

/**
 * @program: lgq_customer
 * @description
 * @author: lgq
 * @create: 2020-03-21 17:22
 **/
@Data
public class WebApiResult<T> {

    public T data;
    public String code;
    public String message;


}