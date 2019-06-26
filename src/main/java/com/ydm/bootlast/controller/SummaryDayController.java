package com.ydm.bootlast.controller;

import com.ydm.bootlast.model.Result;
import com.ydm.bootlast.model.SummaryDay;
import com.ydm.bootlast.service.ISummaryDayService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * summary_day 表 crud 接口
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 14:26
 */
@RestController
@RequestMapping(produces = "application/json")
@Api(tags = {"日汇总数据操作接口"},description = "SummaryDayController")
public class SummaryDayController {

    @Autowired
    private ISummaryDayService summaryDayService;

    @GetMapping("GET/summary-day/{index}")
    @ApiOperation(value = "使用sIndex查询日汇总数据")
    @ApiImplicitParam(name = "index",value = "唯一sIndex",dataType = "String",paramType = "path",required = true)
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<List<SummaryDay>> findByIndex(@PathVariable("index")String index){
        Result<List<SummaryDay>> result = new Result<>();
        result.setData(summaryDayService.findByIndex(index));
        result.setCode(200);
        result.setMsg("查询成功");
        return result;
    }

    @PutMapping("PUT/summary-day")
    @ApiOperation(value = "根据sIndex更新一条交易数据")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<Integer> updateByIndex(@RequestBody SummaryDay summaryDay){
        Result<Integer> result = new Result<>();
        int rows = summaryDayService.updateByIndex(summaryDay);
        result.setData(rows);
        result.setCode(200);
        if(rows == 0){
            result.setMsg("更新失败");
        }else {
            result.setMsg("更新成功");
        }
        return result;
    }

    @PostMapping("POST/summary-day")
    @ApiOperation(value = "保存一条汇总数据")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<Integer> saveOne(@RequestBody SummaryDay summaryDay){
        Result<Integer> result = new Result<>();
        int rows = summaryDayService.saveOne(summaryDay);
        result.setData(rows);
        result.setCode(200);
        if(rows == 0){
            result.setMsg("保存失败");
        }else {
            result.setMsg("保存成功");
        }
        return result;
    }


    @DeleteMapping("DELETE/summary-day/{index}")
    @ApiOperation(value = "根据汇总数据的index和客户id删除一条汇总数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "index",value = "汇总index",dataType = "string",paramType = "path",required = true),
            @ApiImplicitParam(name = "id",value = "客户id",dataType = "int",paramType = "query",required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<Integer> deleteByIndex(String index,@RequestParam("id") int id){
        Result<Integer> result = new Result<>();
        int rows = summaryDayService.deleteByIndex(index,id);
        result.setData(rows);
        result.setCode(200);
        if(rows == 0){
            result.setMsg("删除失败");
        }else {
            result.setMsg("删除成功");
        }
        return result;
    }


}
