package com.eai.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.eai.mybatis.dao.MybatisUserXMLMapper;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
//@EnableAutoConfiguration
@SpringBootTest
public class TestCase {
	
	@Autowired
	private MybatisUserXMLMapper MybatisUserXMLMapper1;
	
//	@Autowired
//	private IXMLService iXMLService;

//    @Test
//    public void simpleTest1(){
//        //创建mock对象，参数可以是类，也可以是接口
//        List<String> list = mock(List.class);
// 
//        //设置方法的预期返回值
//        when(list.get(0)).thenReturn("helloworld");
// 
//        String result = list.get(0);
// 
//        //验证方法调用(是否调用了get(0))
//        verify(list).get(0);
// 
//        //junit测试
//        Assert.assertEquals("helloworld", result);
//    }
	
//  @Test
//  public void simpleTest2(){
//	  iXMLService.getUser(123);
//  }
  
  @Test
  public void simpleTest2(){
	  //MybatisUserXMLMapper1.getUser(999);
  }
}
