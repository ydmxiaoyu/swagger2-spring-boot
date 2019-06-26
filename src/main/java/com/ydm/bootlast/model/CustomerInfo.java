package com.ydm.bootlast.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 客户信息实体
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/21 11:51
 */
@ApiModel(value = "客户信息",description = "客户信息Model")
public class CustomerInfo {

    /**
     * 客户号
     */
    @ApiModelProperty(name = "id",value = "客户号")
    private Integer custId;

    /**
     * 客户姓名
     */
    @ApiModelProperty(name = "surname",value = "客户姓名")
    private String surname;

    /**
     * 性别
     */
    @ApiModelProperty(name = "gender",value = "性别")
    private char gender;

    /**
     * 教育状况
     */
    @ApiModelProperty(name = "educaDes",value = "教育状况")
    private String educaDes;

    /**
     * 婚姻状况
     */
    @ApiModelProperty(name = "marDes",value = "婚姻状况")
    private String marDes;

    /**
     * 生日
     */
    @ApiModelProperty(name = "birthday",value = "生日")
    private Integer birthday;

    /**
     * 住址
     */
    @ApiModelProperty(name = "address",value = "住址")
    private String address;

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "custId=" + custId +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", educaDes='" + educaDes + '\'' +
                ", marDes='" + marDes + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEducaDes() {
        return educaDes;
    }

    public void setEducaDes(String educaDes) {
        this.educaDes = educaDes;
    }

    public String getMarDes() {
        return marDes;
    }

    public void setMarDes(String marDes) {
        this.marDes = marDes;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
