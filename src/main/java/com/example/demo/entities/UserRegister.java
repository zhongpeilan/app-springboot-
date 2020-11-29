package com.example.demo.entities;


public class UserRegister {
    private int p_id;
    private String p_name;
    private String p_headPhoto;
    private String p_sex;
    private String p_telephone;
    private String p_address;
    private String p_region;
    private String p_idCardPositive;
    private String p_idCardReverse;
    private String p_identity;
    private String p_password;
    private String p_token;
    private String p_contact;
    private int p_audit;
    private String p_shoucang;

    public UserRegister(int p_id, String p_name, String p_headPhoto, String p_sex, String p_telephone, String p_address, String p_region, String p_idCardPositive, String p_idCardReverse, String p_identity, String p_password, String p_token, String p_contact, int p_audit, String p_shoucang) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_headPhoto = p_headPhoto;
        this.p_sex = p_sex;
        this.p_telephone = p_telephone;
        this.p_address = p_address;
        this.p_region = p_region;
        this.p_idCardPositive = p_idCardPositive;
        this.p_idCardReverse = p_idCardReverse;
        this.p_identity = p_identity;
        this.p_password = p_password;
        this.p_token = p_token;
        this.p_contact = p_contact;
        this.p_audit = p_audit;
        this.p_shoucang = p_shoucang;
    }
    public UserRegister(){

    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_headPhoto() {
        return p_headPhoto;
    }

    public void setP_headPhoto(String p_headPhoto) {
        this.p_headPhoto = p_headPhoto;
    }

    public String getP_sex() {
        return p_sex;
    }

    public void setP_sex(String p_sex) {
        this.p_sex = p_sex;
    }

    public String getP_telephone() {
        return p_telephone;
    }

    public void setP_telephone(String p_telephone) {
        this.p_telephone = p_telephone;
    }

    public String getP_address() {
        return p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public String getP_region() {
        return p_region;
    }

    public void setP_region(String p_region) {
        this.p_region = p_region;
    }

    public String getP_idCardPositive() {
        return p_idCardPositive;
    }

    public void setP_idCardPositive(String p_idCardPositive) {
        this.p_idCardPositive = p_idCardPositive;
    }

    public String getP_idCardReverse() {
        return p_idCardReverse;
    }

    public void setP_idCardReverse(String p_idCardReverse) {
        this.p_idCardReverse = p_idCardReverse;
    }

    public String getP_identity() {
        return p_identity;
    }

    public void setP_identity(String p_identity) {
        this.p_identity = p_identity;
    }

    public String getP_password() {
        return p_password;
    }

    public void setP_password(String p_password) {
        this.p_password = p_password;
    }

    public String getP_token() {
        return p_token;
    }

    public void setP_token(String p_token) {
        this.p_token = p_token;
    }

    public String getP_contact() {
        return p_contact;
    }

    public void setP_contact(String p_contact) {
        this.p_contact = p_contact;
    }

    public int getP_audit() {
        return p_audit;
    }

    public void setP_audit(int p_audit) {
        this.p_audit = p_audit;
    }

    public String getP_shoucang() {
        return p_shoucang;
    }

    public void setP_shoucang(String p_shoucang) {
        this.p_shoucang = p_shoucang;
    }
}
