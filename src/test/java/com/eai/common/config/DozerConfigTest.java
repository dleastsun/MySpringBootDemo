package com.eai.common.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DozerConfigTest {
    
    private static Mapper dozerMapper;
    
    @Before
    public void setUp() throws Exception {
        dozerMapper = new DozerBeanMapper();
    }

    
    @Ignore
    @Test
    public void test1() throws Exception {
        System.out.println("ok");
//        dozerMapper.map(null, null);
    }
}
