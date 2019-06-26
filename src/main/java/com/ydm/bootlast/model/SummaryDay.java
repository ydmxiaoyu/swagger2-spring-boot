package com.ydm.bootlast.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * 日汇总统计实体
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/21 11:52
 */
@ApiModel(value = "日汇总数据",description = "日汇总数据Model")
public class SummaryDay {

    /**
     * 索引项
     */
    @ApiModelProperty(name = "sIndex",value = "索引项")
    private String sIndex;

    /**
     * 客户号
     */
    @ApiModelProperty(name = "custId",value = "客户号")
    private Integer custId;

    /**
     * 更新时间
     */
    @ApiModelProperty(name = "updateTime",value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 日期
     */
    @ApiModelProperty(name = "transDate",value = "日期")
    private java.sql.Date transDate;

    /**
     * 客户姓名
     */
    @ApiModelProperty(name = "surname",value = "客户姓名")
    private String surname;

    /**
     * 最大单笔交易金额
     */
    @ApiModelProperty(name = "tranMaxAmt",value = "最大单笔交易金额")
    private BigDecimal tranMaxAmt;

    /**
     * 当天还款总金额
     */
    @ApiModelProperty(name = "payAmt",value = "当天还款总金额")
    private BigDecimal payAmt;

    /**
     * 当天消费笔数
     */
    @ApiModelProperty(name = "tranCnt",value = "当天消费笔数")
    private Integer tranCnt;

    /**
     * 当天还款笔数
     */
    @ApiModelProperty(name = "payCnt",value = "当天还款笔数")
    private Integer payCnt;

    /**
     * 当天交易总金额
     */
    @ApiModelProperty(name = "tranAmt",value = "当天交易总金额")
    private BigDecimal tranAmt;

    @Override
    public String toString() {
        return "SummaryDay{" +
                "sIndex='" + sIndex + '\'' +
                ", custId=" + custId +
                ", updateTime=" + updateTime +
                ", transDate=" + transDate +
                ", surname='" + surname + '\'' +
                ", tranMaxAmt=" + tranMaxAmt +
                ", payAmt=" + payAmt +
                ", tranCnt=" + tranCnt +
                ", payCnt=" + payCnt +
                ", tranAmt=" + tranAmt +
                '}';
    }

    public String getsIndex() {
        return sIndex;
    }

    public void setsIndex(String sIndex) {
        this.sIndex = sIndex;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getTranMaxAmt() {
        return tranMaxAmt;
    }

    public void setTranMaxAmt(BigDecimal tranMaxAmt) {
        this.tranMaxAmt = tranMaxAmt;
    }

    public BigDecimal getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }

    public Integer getTranCnt() {
        return tranCnt;
    }

    public void setTranCnt(Integer tranCnt) {
        this.tranCnt = tranCnt;
    }

    public Integer getPayCnt() {
        return payCnt;
    }

    public void setPayCnt(Integer payCnt) {
        this.payCnt = payCnt;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }
}
