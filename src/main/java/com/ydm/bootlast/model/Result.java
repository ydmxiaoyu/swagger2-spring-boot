package com.ydm.bootlast.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 封装返回到页面的类
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 21:45
 */
@Data
@ApiModel
public class Result<T> {

    @ApiModelProperty(name = "code",value = "状态码")
    private int code;

    @ApiModelProperty(name = "msg",value = "结果")
    private String msg;

    @ApiModelProperty(name = "data",value = "对象数据")
    private T data;



}
