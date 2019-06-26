package com.ydm.bootlast.service;

/**
 * 测试 CustomerInfoService
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 17:07
 */

import com.ydm.bootlast.model.CustomerInfo;
import com.ydm.bootlast.service.impl.CustomerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCustomerInfoService {

    @Autowired
    private CustomerInfoService customerInfoService;

    private CustomerInfo customerInfo;

    @Before
    public void init(){
        customerInfo = new CustomerInfo();
        customerInfo.setCustId(111);
        customerInfo.setAddress("北京");
        customerInfo.setBirthday(20000101);
        customerInfo.setGender('男');
        customerInfo.setSurname("雨神");
        customerInfo.setEducaDes("本科");
        customerInfo.setMarDes("未婚");
    }

    @Test
    public void findById(){
        CustomerInfo customerInfo = customerInfoService.findById(10);
        log.info(customerInfo.toString());
    }

    @Test
    public void updateById(){
        int result = customerInfoService.updateById(customerInfo);
        log.info("更新结果：{}",result==0?false:true);
    }

    @Test
    public void deleteById(){
        int result = customerInfoService.deleteById(111);
        log.info("删除结果：{}",result == 0 ? false : true);
    }

    @Test
    public void saveOne(){
        int result = customerInfoService.saveOne(customerInfo);
        log.info("保存结果：{}",result==0?false:true);
    }


}
