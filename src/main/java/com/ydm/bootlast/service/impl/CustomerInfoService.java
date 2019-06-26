package com.ydm.bootlast.service.impl;

import com.ydm.bootlast.dao.CustomerInfoMapper;
import com.ydm.bootlast.model.CustomerInfo;
import com.ydm.bootlast.service.ICustomerInfoService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客户信息业务处理逻辑
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 9:29
 */
@Service
public class CustomerInfoService implements ICustomerInfoService{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 根据客户id查询信息
     * @param id 客户id
     * @return CustomerInfo 查询到的客户信息，null 未查询到该客户
     */
    @Override
    public CustomerInfo findById(int id){
        CustomerInfoMapper customerInfoMapper = sqlSessionTemplate.getMapper(CustomerInfoMapper.class);
        return customerInfoMapper.findById(id);
    }

    /**
     * 根据客户id更新信息
     * @param cus 需要更新的CustomerInfo
     * @return 0 更新失败，1 更新成功
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    @Override
    public int updateById(CustomerInfo cus){
        CustomerInfoMapper customerInfoMapper = sqlSessionTemplate.getMapper(CustomerInfoMapper.class);
        return customerInfoMapper.updateById(cus);
    }

    /**
     * 保存一条客户信息
     * @param cus 需要保存的CustomerInfo
     * @return 0 保存失败，1 保存成功
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    @Override
    public int saveOne(CustomerInfo cus){
        CustomerInfoMapper customerInfoMapper = sqlSessionTemplate.getMapper(CustomerInfoMapper.class);
        return customerInfoMapper.saveOne(cus);
    }

    /**
     * 根据客户id删除信息
     * @param id 客户id
     * @return 0 删除失败，1 删除成功
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    @Override
    public int deleteById(int id){
        CustomerInfoMapper customerInfoMapper = sqlSessionTemplate.getMapper(CustomerInfoMapper.class);
        return customerInfoMapper.deleteById(id);
    }

}
