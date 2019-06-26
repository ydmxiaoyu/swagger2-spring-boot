package com.ydm.bootlast.service.impl;

import com.ydm.bootlast.dao.SummaryDayMapper;
import com.ydm.bootlast.model.SummaryDay;
import com.ydm.bootlast.service.ISummaryDayService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 日汇总统计表业务处理逻辑
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 9:29
 */
@Service
public class SummaryDayService implements ISummaryDayService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 根据s_index查询指定客户的交易汇总信息
     * @param index s_index
     * @return List<SummaryDay> 日汇总统计数据的list集合
     */
    @Override
    public List<SummaryDay> findByIndex(String index){
        SummaryDayMapper summaryDayMapper = sqlSessionTemplate.getMapper(SummaryDayMapper.class);
        return summaryDayMapper.findByIndex(index);
    }


    /**
     * 保存一个客户当天的交易汇总数据
     * @param summaryDay SummaryDay对象
     * @return 0保存失败，1保存成功
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    public int saveOne(SummaryDay summaryDay){
        SummaryDayMapper summaryDayMapper = sqlSessionTemplate.getMapper(SummaryDayMapper.class);
        return summaryDayMapper.saveOne(summaryDay);
    }


    /**
     * 根据 s_index 和客户号更新
     * @param summaryDay SummaryDay 对象
     * @return 0 更新失败，1 更新成功
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    public int updateByIndex(SummaryDay summaryDay){
        SummaryDayMapper summaryDayMapper = sqlSessionTemplate.getMapper(SummaryDayMapper.class);
        return summaryDayMapper.updateByIndex(summaryDay);
    }


    /**
     * 根据 s_index 和客户号删除
     * @param index s_index
     * @param id 客户号
     * @return 0 删除失败，1 删除成功
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    public int deleteByIndex(String index,int id){
        SummaryDayMapper summaryDayMapper = sqlSessionTemplate.getMapper(SummaryDayMapper.class);
        return summaryDayMapper.deleteByIndex(index,id);
    }

}
