package com.ydm.bootlast.dao;

import com.ydm.bootlast.model.TransInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * trans_info 表的 mapper
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/21 16:48
 */
@Mapper
@Component
public interface TransInfoMapper {

    /**
     * 根据交易id查询交易数据
     * @param id 交易id
     * @return 交易数据 或者 null
     */
    @Select({"select * from trans_info where trans_id = #{transId}"})
    public TransInfo findById(int id);


    /**
     * 实现分页查询
     * @param startIndex 从第几条数据开始，最小值为 0
     * @param pageSize 一页有多少条数据
     * @return List<TransInfo>
     */
    @Select({"select * from trans_info limit #{startIndex},#{pageSize}"})
    public List<TransInfo> pageSerach(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    /**
     * 根据交易id更新交易数据
     * @param transInfo 交易信息 TransInfo
     * @return 0 更新失败，1 更新成功
     */
    @Update({"update trans_info set cust_id = #{custId}, account = #{account}, card_nbr = #{cardNbr}, tranno = #{tranno}, month_nbr = #{monthNbr}, bill = #{bill}, trans_type = #{transType}, txn_datetime = #{txnDatetime} where trans_id = #{transId}"})
    public int updateOne(TransInfo transInfo);


    /**
     * 保存一条交易数据
     * @param transInfo TransInfo
     * @return 0 保存失败，1 保存成功
     */
    @Insert({"insert into trans_info(trans_id,cust_id,account,card_nbr,tranno,month_nbr,bill,trans_type,txn_datetime) values(#{transId},#{custId},#{account},#{cardNbr},#{tranno},#{monthNbr},#{bill},#{transType},#{txnDatetime})"})
    public int saveOne(TransInfo transInfo);


    /**
     * 根据交易id删除数据
     * @param id 交易id
     * @return 0 删除失败，1 删除成功
     */
    @Delete({"delete from trans_info where trans_id = #{transId}"})
    public int deleteById(int id);

}
