package com.ydm.bootlast.service.impl;

import com.ydm.bootlast.dao.TransInfoMapper;
import com.ydm.bootlast.model.TransInfo;
import com.ydm.bootlast.service.ITransInfoService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 交易明细表业务处理逻辑
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 9:30
 */
@Service
public class TransInfoService implements ITransInfoService{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    /**
     * 根据交易id查询交易数据
     * @param id 交易id
     * @return 交易数据 或者 null
     */
    @Override
    public TransInfo findById(int id) {
        TransInfoMapper transInfoMapper = sqlSessionTemplate.getMapper(TransInfoMapper.class);
        return transInfoMapper.findById(id);
    }

    /**
     * 实现分页查询
     * @param currentPage 要显示的页面，最小值为 1
     * @param pageSize 一页有多少条数据
     * @return List<TransInfo>
     */
    @Override
    public List<TransInfo> pageSerach(int currentPage,int pageSize){
        //计算出要显示页面的第一条数据的索引
        int startIndex = (currentPage - 1) * pageSize;
        TransInfoMapper transInfoMapper = sqlSessionTemplate.getMapper(TransInfoMapper.class);
        return transInfoMapper.pageSerach(startIndex,pageSize);
    }


    /**
     * 根据交易id更新交易数据
     * @param transInfo 交易信息 TransInfo
     * @return 0 更新失败，1 更新成功
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    public int updateOne(TransInfo transInfo) {
        TransInfoMapper transInfoMapper = sqlSessionTemplate.getMapper(TransInfoMapper.class);
        return transInfoMapper.updateOne(transInfo);
    }

    /**
     * 保存一条交易数据
     * @param transInfo TransInfo
     * @return 0 保存失败，1 保存成功
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    public int saveOne(TransInfo transInfo) {
        TransInfoMapper transInfoMapper = sqlSessionTemplate.getMapper(TransInfoMapper.class);
        return transInfoMapper.saveOne(transInfo);
    }

    /**
     * 根据交易id删除数据
     * @param id 交易id
     * @return 0 删除失败，1 删除成功
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    public int deleteById(int id) {
        TransInfoMapper transInfoMapper = sqlSessionTemplate.getMapper(TransInfoMapper.class);
        return transInfoMapper.deleteById(id);
    }
}
