package com.example.crm.domain;

public class Customer {
    private Long cust_id;           //客户编号(主键)
    private String cust_name;       //客户名称
//    private String cust_source;     //客户信息来源
//    private String cust_industry;   //客户所属行业
//    private String cust_level;      //客户级别
    private BaseDict baseDictSource;
    private BaseDict baseDictIndustry;
    private BaseDict baseDictLevel;
    private String cust_phone;      //固定电话
    private String cust_mobile;          //移动电话
    private String cust_image;

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public BaseDict getBaseDictSource() {
        return baseDictSource;
    }

    public void setBaseDictSource(BaseDict baseDictSource) {
        this.baseDictSource = baseDictSource;
    }

    public BaseDict getBaseDictIndustry() {
        return baseDictIndustry;
    }

    public void setBaseDictIndustry(BaseDict baseDictIndustry) {
        this.baseDictIndustry = baseDictIndustry;
    }

    public BaseDict getBaseDictLevel() {
        return baseDictLevel;
    }

    public void setBaseDictLevel(BaseDict baseDictLevel) {
        this.baseDictLevel = baseDictLevel;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    public String getCust_image() {
        return cust_image;
    }

    public void setCust_image(String cust_image) {
        this.cust_image = cust_image;
    }

}
