package com.ydm.bootlast.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 交易明细实体
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/21 11:52
 */
@ApiModel(value = "交易明细实体",description = "交易明细Model")
public class TransInfo {

    /**
     * 交易id
     */
    @ApiModelProperty(name = "transId",value = "交易id")
    private Integer transId;

    /**
     * 客户号
     */
    @ApiModelProperty(name = "custId",value = "客户号")
    private Integer custId;

    /**
     * 账户号
     */
    @ApiModelProperty(name = "account",value = "账户号")
    private String account;

    /**
     * 卡号
     */
    @ApiModelProperty(name = "cardNbr",value = "卡号")
    private String cardNbr;

    /**
     * 交易流水号
     */
    @ApiModelProperty(name = "tranno",value = "交易流水号")
    private Integer tranno;

    /**
     * 账单月
     */
    @ApiModelProperty(name = "monthNbr",value = "账单月")
    private Integer monthNbr;

    /**
     * 交易金额
     */
    @ApiModelProperty(name = "bill",value = "交易金额")
    private BigDecimal bill;

    /**
     * 交易类型
     */
    @ApiModelProperty(name = "transType",value = "交易类型")
    private String transType;

    /**
     * 交易日期
     */
    @ApiModelProperty(name = "txnDatetime",value = "交易日期")
    private LocalDateTime txnDatetime;

    @Override
    public String toString() {
        return "TransInfo{" +
                "transId=" + transId +
                ", custId=" + custId +
                ", account='" + account + '\'' +
                ", cardNbr='" + cardNbr + '\'' +
                ", tranno=" + tranno +
                ", monthNbr=" + monthNbr +
                ", bill=" + bill +
                ", transType='" + transType + '\'' +
                ", txnDatetime=" + txnDatetime +
                '}';
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCardNbr() {
        return cardNbr;
    }

    public void setCardNbr(String cardNbr) {
        this.cardNbr = cardNbr;
    }

    public Integer getTranno() {
        return tranno;
    }

    public void setTranno(Integer tranno) {
        this.tranno = tranno;
    }

    public Integer getMonthNbr() {
        return monthNbr;
    }

    public void setMonthNbr(Integer monthNbr) {
        this.monthNbr = monthNbr;
    }

    public BigDecimal getBill() {
        return bill;
    }

    public void setBill(BigDecimal bill) {
        this.bill = bill;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public LocalDateTime getTxnDatetime() {
        return txnDatetime;
    }

    public void setTxnDatetime(LocalDateTime txnDatetime) {
        this.txnDatetime = txnDatetime;
    }
}
