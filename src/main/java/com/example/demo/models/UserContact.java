package com.example.demo.models;

//联系人的姓名和电话号码
public class UserContact {
    private String c_name;
    private String c_telephone;
    private String p_telephone;

    public UserContact(String c_name, String c_telephone, String p_telephone) {
        this.c_name = c_name;
        this.c_telephone = c_telephone;
        this.p_telephone = p_telephone;
    }
    public UserContact(){

    }


    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_telephone() {
        return c_telephone;
    }

    public void setC_telephone(String c_telephone) {
        this.c_telephone = c_telephone;
    }

    public String getP_telephone() {
        return p_telephone;
    }

    public void setP_telephone(String p_telephone) {
        this.p_telephone = p_telephone;
    }
}
