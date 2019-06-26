package com.ydm.bootlast.dao;

import com.ydm.bootlast.model.SummaryDay;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * summary_day 表的 mapper
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/21 16:47
 */
@Mapper
@Component
public interface SummaryDayMapper {

    /**
     * 根据s_index查询指定客户的交易汇总信息
     * @param sIndex s_index
     * @return List<SummaryDay> 日汇总统计数据的list集合
     */
    @Select({"select * from summary_day where s_index = #{sIndex}"})
    public List<SummaryDay> findByIndex(String sIndex);


    /**
     * 保存一个客户当天的交易汇总数据
     * @param summaryDay SummaryDay对象
     * @return 0保存失败，1保存成功
     */
    @Insert({"insert into summary_day(s_index,cust_id,update_time,trans_date,surname,tran_max_amt,pay_amt,tran_cnt,pay_cnt,tran_amt) " +
            "values(#{sIndex},#{custId},#{updateTime},#{transDate},#{surname},#{tranMaxAmt},#{payAmt},#{tranCnt},#{payCnt},#{tranAmt})"})
    public int saveOne(SummaryDay summaryDay);


    /**
     * 根据 s_index 和客户号更新
     * @param summaryDay SummaryDay 对象
     * @return 0 更新失败，1 更新成功
     */
    @Update({"update summary_day set s_index = #{sIndex},cust_id = #{custId},update_time = #{updateTime},trans_date = #{transDate},surname = #{surname},tran_max_amt = #{tranMaxAmt}," +
            "pay_amt = #{payAmt},tran_cnt = #{tranCnt},pay_cnt = #{payCnt},tran_amt = #{tranAmt} where s_index = #{sIndex} and cust_id = #{custId}"})
    public int updateByIndex(SummaryDay summaryDay);


    /**
     * 根据 s_index 和客户号删除
     * @param sIndex s_index
     * @param id 客户号
     * @return 0 删除失败，1 删除成功
     */
    @Delete({"delete from summary_day where s_index = #{sIndex} and cust_id = #{id}"})
    public int deleteByIndex(@Param("sIndex") String sIndex,@Param("id") int id);

}
