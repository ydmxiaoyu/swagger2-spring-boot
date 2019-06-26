package com.ydm.bootlast.service;

import com.ydm.bootlast.model.TransInfo;

import java.util.List;

/**
 * 交易明细表 service 接口
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 9:27
 */
public interface ITransInfoService {

    /**
     * 根据交易id查询交易数据
     * @param id 交易id
     * @return 交易数据 或者 null
     */
    public TransInfo findById(int id);


    /**
     * 实现分页查询
     * @param currentPage 要显示的页面，最小值为 1
     * @param pageSize 一页有多少条数据
     * @return List<TransInfo>
     */
    public List<TransInfo> pageSerach(int currentPage, int pageSize);

    /**
     * 根据交易id更新交易数据
     * @param transInfo 交易信息 TransInfo
     * @return 0 更新失败，1 更新成功
     */
    public int updateOne(TransInfo transInfo);


    /**
     * 保存一条交易数据
     * @param transInfo TransInfo
     * @return 0 保存失败，1 保存成功
     */
    public int saveOne(TransInfo transInfo);


    /**
     * 根据交易id删除数据
     * @param id 交易id
     * @return 0 删除失败，1 删除成功
     */
    public int deleteById(int id);

}
