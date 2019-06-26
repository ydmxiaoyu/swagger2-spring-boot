package com.ydm.bootlast.service;

import com.ydm.bootlast.model.SummaryDay;
import com.ydm.bootlast.model.TransInfo;

import java.util.List;

/**
 * 日汇总统计表 service 接口
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 9:27
 */
public interface ISummaryDayService {

    /**
     * 根据s_index查询指定客户的交易汇总信息
     * @param index s_index
     * @return List<SummaryDay> 日汇总统计数据的list集合
     */
    public List<SummaryDay> findByIndex(String index);


    /**
     * 保存一个客户当天的交易汇总数据
     * @param summaryDay SummaryDay对象
     * @return 0保存失败，1保存成功
     */
    public int saveOne(SummaryDay summaryDay);


    /**
     * 根据 s_index 和客户号更新
     * @param summaryDay SummaryDay 对象
     * @return 0 更新失败，1 更新成功
     */
    public int updateByIndex(SummaryDay summaryDay);


    /**
     * 根据 s_index 和客户号删除
     * @param index s_index
     * @param id 客户号
     * @return 0 删除失败，1 删除成功
     */
    public int deleteByIndex(String index,int id);

}
