package com.ydm.bootlast.controller;

import com.ydm.bootlast.model.Result;
import com.ydm.bootlast.model.TransInfo;
import com.ydm.bootlast.service.ITransInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * trans_info 表 crud 接口
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 14:26
 */
@RestController
@RequestMapping(produces = "application/json")
@Api(tags = {"交易数据操作接口"},description = "TransInfoController")
public class TransInfoController {

    @Autowired
    private ITransInfoService transInfoService;

    @GetMapping("GET/trans-info/{id}")
    @ApiOperation(value = "使用交易id查询交易数据")
    @ApiImplicitParam(name = "id",value = "交易ID",dataType = "int",paramType = "path",required = true)
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<TransInfo> findById(@PathVariable("id")int id){
        Result<TransInfo> result = new Result<>();
        result.setData(transInfoService.findById(id));
        result.setCode(200);
        result.setMsg("查询成功");
        return result;
    }

    @GetMapping("GET/trans-info")
    @ApiOperation(value = "根据要显示的页面页码和页面大小来查询该页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "查询的页面页码",dataType = "int",paramType = "query",required = true),
            @ApiImplicitParam(name = "pageSize",value = "页面显示多少条数据",dataType = "int",paramType = "query",required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<List<TransInfo>> pageSerach(@RequestParam("currentPage") int currentPage,@RequestParam("pageSize") int pageSize){
        Result<List<TransInfo>> result = new Result<>();
        result.setData(transInfoService.pageSerach(currentPage,pageSize));
        result.setCode(200);
        result.setMsg("查询成功");
        return result;
    }

    @PutMapping("PUT/trans-info")
    @ApiOperation(value = "根据交易id更新一条交易数据")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<Integer> updateOne(@RequestBody TransInfo transInfo){
        Result<Integer> result = new Result<>();
        int rows = transInfoService.updateOne(transInfo);
        result.setData(rows);
        result.setCode(200);
        if(rows == 0){
            result.setMsg("更新失败");
        }else {
            result.setMsg("更新成功");
        }
        return result;
    }

    @PostMapping("POST/trans-info")
    @ApiOperation(value = "保存一条交易数据")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<Integer> saveOne(@RequestBody TransInfo transInfo){
        Result<Integer> result = new Result<>();
        int rows = transInfoService.saveOne(transInfo);
        result.setData(rows);
        result.setCode(200);
        if(rows == 0){
            result.setMsg("保存失败");
        }else {
            result.setMsg("保存成功");
        }
        return result;
    }

    @DeleteMapping("DELETE/trans-info/{id}")
    @ApiOperation(value = "根据交易id删除一条交易数据")
    @ApiImplicitParam(name = "id",value = "交易ID",dataType = "int",paramType = "path",required = true)
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<Integer> deleteById(@PathVariable("id")int id){
        Result<Integer> result = new Result<>();
        int rows = transInfoService.deleteById(id);
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
