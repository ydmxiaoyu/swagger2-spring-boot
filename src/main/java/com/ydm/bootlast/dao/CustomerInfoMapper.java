package com.ydm.bootlast.dao;

import com.ydm.bootlast.model.CustomerInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * customer_info 表的 mapper
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/21 16:47
 */
@Mapper
@Component
public interface CustomerInfoMapper {

    /**
     * 根据客户id查询信息
     * @param id 客户id
     * @return CustomerInfo 查询到的客户信息，null 未查询到该客户
     */
    @Select({"select cust_id,surname,gender,educa_des,mar_des,birthday,address from customer_info where cust_id = #{id}"})
    public CustomerInfo findById(int id);

    /**
     * 根据客户id更新信息
     * @param cus 需要更新的CustomerInfo
     * @return 0 更新失败，1 更新成功
     */
    @Update({"update customer_info set surname = #{surname}, gender = #{gender}, educa_des = #{educaDes}, mar_des = #{marDes}, birthday = #{birthday}, address = #{address} where cust_id = #{custId}"})
    public int updateById(CustomerInfo cus);

    /**
     * 保存一条客户信息
     * @param cus 需要保存的CustomerInfo
     * @return 0 保存失败，1 保存成功
     */
    @Insert({"insert into customer_info(cust_id,surname,gender,educa_des,mar_des,birthday,address) values(#{custId},#{surname},#{gender},#{educaDes},#{marDes},#{birthday},#{address})"})
    public int saveOne(CustomerInfo cus);


    /**
     * 根据客户id删除信息
     * @param id 客户id
     * @return 0 删除失败，1 删除成功
     */
    @Delete({"delete from customer_info where cust_id = #{custId}"})
    public int deleteById(int id);

}
