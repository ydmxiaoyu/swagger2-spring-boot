

CREATE DATABASE customer CHARACTER SET utf8 COLLATE utf8_general_ci;

use customer;

# 客户信息表
CREATE TABLE customer_info(
  cust_id INT AUTO_INCREMENT COMMENT '客户号',
  surname VARCHAR(20) COMMENT '客户姓名',
  gender VARCHAR(1) COMMENT '性别',
  educa_des VARCHAR(20) COMMENT '教育状况',
  mar_des VARCHAR(20) COMMENT '婚姻状况',
  birthday INT COMMENT '生日',
  address VARCHAR(50) COMMENT '住址',
  PRIMARY KEY (cust_id)
)ENGINE = Innodb DEFAULT CHARSET = utf8;


# 交易明细表
CREATE TABLE trans_info(
  trans_id INT AUTO_INCREMENT COMMENT '交易id',
  cust_id INT COMMENT '客户号',
  account VARCHAR(10) COMMENT '账户号',
  card_nbr VARCHAR(16) COMMENT '卡号',
  tranno INT COMMENT '交易流水号',
  month_nbr INT COMMENT '账单月',
  bill DECIMAL(11,2) COMMENT '交易金额',
  trans_type VARCHAR(30) COMMENT '交易类型',
  txn_datetime DATETIME COMMENT '交易日期',
  PRIMARY KEY (trans_id)
)ENGINE = Innodb DEFAULT CHARSET = utf8;


# 日汇总统计表
CREATE TABLE summary_day(
  s_index VARCHAR(30) COMMENT '索引项',
  cust_id INT COMMENT '客户号',
  update_time DATETIME COMMENT '更新时间',
  trans_date DATE COMMENT '日期',
  surname VARCHAR(20) COMMENT '客户姓名',
  tran_max_amt DECIMAL(11,2) COMMENT '最大单笔交易金额',
  pay_amt DECIMAL(11,2) COMMENT '当天还款总金额',
  tran_cnt INT COMMENT '当天消费笔数',
  pay_cnt INT COMMENT '当天还款笔数',
  tran_amt DECIMAL(11,2) COMMENT '当天交易总金额'
)ENGINE = Innodb DEFAULT CHARSET = utf8;

