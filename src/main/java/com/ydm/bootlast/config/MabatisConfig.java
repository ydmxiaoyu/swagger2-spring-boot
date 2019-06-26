package com.ydm.bootlast.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Mybatis 配置类
 *
 * @author yudaoming
 * @version 1.0
 */
@Configuration
@Slf4j
public class MabatisConfig {

    /**
     * 应用上下文对象
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 加载 mybatis 的配置，
     * 解决驼峰命令自动转换配置不生效的问题
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration config(){
        return new org.apache.ibatis.session.Configuration();
    }

    /**
     * 配置 sqlSessionFactory 对象
     * @return SqlSessionFactoryBean 或者是 null
     */
    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("config")org.apache.ibatis.session.Configuration config){
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            DataSource dataSource = applicationContext.getBean(DataSource.class);
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setConfiguration(config);
            return sqlSessionFactoryBean.getObject();
        }catch (Exception e){
            log.error("创建bean的sqlSessionFactory（）方法发生异常，异常信息：");
            log.error(e.getMessage());
        }
        return null;
    }


    /**
     * 配置 SqlSessionTemplate 对象
     * @return SqlSessionTemplate
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(){
        return new SqlSessionTemplate(sqlSessionFactory(config()));
    }

}
