/*
 * (c)2018 NTT Communications Corporation All Rights Reserved.
 */

package com.eai.common.config;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * 
 * @author xudong.li
 *
 */
@Configuration
public class DozerConfig {
    /**
     * DozerMapperの設定ファイル。
     */
    @Value("classpath*:/dozer/**/*-mapping.xml")
    private Resource[] mappingFiles;

    /**
     * DozerMapperの設定を行う。
     *
     * @return DozerBeanMapperFactoryBean
     */
    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean() {

        DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
        dozerBeanMapperFactoryBean.setMappingFiles(mappingFiles);
        return dozerBeanMapperFactoryBean;
    }
}
