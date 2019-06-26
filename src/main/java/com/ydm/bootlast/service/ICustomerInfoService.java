package com.ydm.bootlast.service;

import com.ydm.bootlast.model.CustomerInfo;

/**
 * 客户信息表service接口
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 9:26
 */
public interface ICustomerInfoService {

    /**
     * 根据客户id查询信息
     * @param id 客户id
     * @return CustomerInfo 查询到的客户信息，null 未查询到该客户
     */
    public CustomerInfo findById(int id);

    /**
     * 根据客户id更新信息
     * @param cus 需要更新的CustomerInfo
     * @return 0 更新失败，1 更新成功
     */
    public int updateById(CustomerInfo cus);

    /**
     * 保存一条客户信息
     * @param cus 需要保存的CustomerInfo
     * @return 0 保存失败，1 保存成功
     */
    public int saveOne(CustomerInfo cus);


    /**
     * 根据客户id删除信息
     * @param id 客户id
     * @return 0 删除失败，1 删除成功
     */
    public int deleteById(int id);

}
