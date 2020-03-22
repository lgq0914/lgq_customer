package com.lgq.lgq_customer.constants;

/**
 * @program: lgq_customer
 * @description
 * @author: lgq
 * @create: 2020-03-21 18:30
 **/
public enum LoginEnum {

    Success("成功","1000"),
    NotRegister("手机号未注册","1001"),
    PassWordWrong ("密码错误","1002")
    ;




    private String code;
    private String name;

    public static String getName(String code){
        for (CustomerEnum vehicleEnum : CustomerEnum.values()) {
            if(vehicleEnum.getCode().equals(code)){
                return vehicleEnum.getName();
            }
        }
        return null;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    LoginEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
