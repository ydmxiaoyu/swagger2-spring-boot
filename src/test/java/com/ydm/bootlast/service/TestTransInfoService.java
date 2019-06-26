package com.ydm.bootlast.service;

import com.ydm.bootlast.model.TransInfo;
import com.ydm.bootlast.service.impl.TransInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * 测试 TransInfoService
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 17:08
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTransInfoService {

    @Autowired
    private TransInfoService transInfoService;

    private TransInfo transInfo;

    @Before
    public void init() {
        transInfo = new TransInfo();

        transInfo.setCustId(7708);
        transInfo.setTranno(1);
        transInfo.setAccount("6211732902");
        transInfo.setCardNbr("6216611901572546");
        transInfo.setTranno(2104524965);
        transInfo.setMonthNbr(5);
        transInfo.setBill(BigDecimal.valueOf(2004.00));
        transInfo.setTransType("消费");
        LocalDate localDate = LocalDate.parse("2019-05-15");
        LocalTime localTime = LocalTime.parse("00:00:00");
        transInfo.setTxnDatetime(LocalDateTime.of(localDate,localTime));
    }

    @Test
    public void findById() {
        TransInfo transInfo = transInfoService.findById(100);
        log.info(transInfo.toString());
    }

    @Test
    public void pageSerach(){
        List<TransInfo> list = transInfoService.pageSerach(1,10);
        for (TransInfo transInfo:list) {
            log.info(transInfo.toString());
        }
    }

    @Test
    public void updateById() {
        int result = transInfoService.updateOne(transInfo);
        log.info("更新结果：{}", result == 0 ? false : true);
    }

    @Test
    public void deleteById() {
        int result = transInfoService.deleteById(1);
        log.info("删除结果：{}", result == 0 ? false : true);
    }

    @Test
    public void saveOne() {
        int result = transInfoService.saveOne(transInfo);
        log.info("保存结果：{}", result == 0 ? false : true);
    }


}
