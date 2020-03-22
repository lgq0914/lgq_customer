package com.lgq.lgq_customer.constants;

public enum CustomerEnum {

    Success("成功","1000"),
    InValid("手机号无效","1001"),
    Repetition("手机号重复","1002"),
    PassWordInValid("密码无效","1003"),
    Exception("异常","1004")
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

    CustomerEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
