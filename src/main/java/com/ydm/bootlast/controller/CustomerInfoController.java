package com.ydm.bootlast.controller;

import com.ydm.bootlast.model.CustomerInfo;
import com.ydm.bootlast.model.Result;
import com.ydm.bootlast.service.ICustomerInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * customer_info 表 crud 接口
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 14:25
 */
@RestController
@RequestMapping(produces = "application/json")
@Api(tags = {"客户信息操作接口"},description = "CustomerInfoController")
public class CustomerInfoController {

    @Autowired
    private ICustomerInfoService customerInfoService;

    @GetMapping("GET/customer/{id}")
    @ApiOperation(value = "使用id查询客户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "客户ID",dataType = "int",paramType = "path",required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<CustomerInfo> findById(@PathVariable("id") int id){
        Result<CustomerInfo> result = new Result<>();
        result.setData(customerInfoService.findById(id));
        result.setCode(200);
        result.setMsg("查询成功");
        return result;
    }


    @PutMapping("PUT/customer")
    @ApiOperation(value = "根据id更新一条客户信息")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<Integer> updateById(@RequestBody CustomerInfo cus){
        Result<Integer> result = new Result<>();
        int rows = customerInfoService.updateById(cus);
        result.setData(rows);
        result.setCode(200);
        if(rows == 0){
            result.setMsg("更新失败");
        }else {
            result.setMsg("更新成功");
        }
        return result;
    }

    @PostMapping("POST/customer")
    @ApiOperation(value = "保存一条客户信息")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<Integer> saveOne(@RequestBody CustomerInfo cus){
        Result<Integer> result = new Result<>();
        int rows = customerInfoService.saveOne(cus);
        result.setData(rows);
        result.setCode(200);
        if(rows == 0){
            result.setMsg("保存失败");
        }else {
            result.setMsg("保存成功");
        }
        return result;
    }

    @DeleteMapping("DELETE/customer/{id}")
    @ApiOperation(value = "根据id删除一条客户信息")
    @ApiImplicitParam(name = "id",value = "客户ID",dataType = "int",paramType = "path",required = true)
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public Result<Integer> deleteById(@PathVariable("id") int id){
        Result<Integer> result = new Result<>();
        int rows = customerInfoService.deleteById(id);
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
