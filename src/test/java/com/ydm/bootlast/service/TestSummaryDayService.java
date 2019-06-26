package com.ydm.bootlast.service;

import com.ydm.bootlast.model.SummaryDay;
import com.ydm.bootlast.service.impl.SummaryDayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * 测试 SummaryDayService
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/24 17:08
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSummaryDayService {
    @Autowired
    private SummaryDayService summaryDayService;

    private SummaryDay summaryDay;

    @Before
    public void init() {
        summaryDay = new SummaryDay();
        LocalDate localDate = LocalDate.parse("2019-06-24");
        LocalTime localTime = LocalTime.parse("03:06:40");

        summaryDay.setCustId(7);
        summaryDay.setsIndex("7_20190430");
        summaryDay.setUpdateTime(LocalDateTime.of(localDate,localTime));
        summaryDay.setTransDate(Date.valueOf(localDate));
        summaryDay.setSurname("姚辰健");
        summaryDay.setTranMaxAmt(BigDecimal.valueOf(5236.00));
        summaryDay.setPayAmt(BigDecimal.valueOf(0.00));
        summaryDay.setTranCnt(1);
        summaryDay.setPayCnt(0);
        summaryDay.setTranAmt(BigDecimal.valueOf(5236.00));

    }

    @Test
    public void findById() {
        List<SummaryDay> list = summaryDayService.findByIndex("7_20190430");
        for (SummaryDay s:list){
            log.info(s.toString());
        }
    }

    @Test
    public void updateById() {
        int result = summaryDayService.updateByIndex(summaryDay);
        log.info("更新结果：{}", result == 0 ? false : true);
    }

    @Test
    public void deleteByIndex() {
        int result = summaryDayService.deleteByIndex(summaryDay.getsIndex(),summaryDay.getCustId());
        log.info("删除结果：{}", result == 0 ? false : true);
    }

    @Test
    public void saveOne() {
        int result = summaryDayService.saveOne(summaryDay);
        log.info("保存结果：{}", result == 0 ? false : true);
    }


}
