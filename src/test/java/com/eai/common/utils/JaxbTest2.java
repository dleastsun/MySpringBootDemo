package com.eai.common.utils;

import org.junit.Test;

import com.eai.common.utils.model.Role;
import com.eai.common.utils.model.Student;

public class JaxbTest2 {
	@Test  
    public void showMarshaller() {  
  
        Student student = new Student();  
        student.setId(12);  
        student.setName("test");  
  
        Role role = new Role();  
        role.setDesc("管理");  
        role.setName("班长");  
  
        student.setRole(role);  
  
        String str = JaxbUtil.convertToXml(student);  
        System.out.println(str);  
    }  
  
    @Test  
    public void showUnMarshaller() {  
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+  
            "<student id=\"12\">"+  
            "    <name>test</name>"+  
             "   <role>"+  
              "      <name>班长</name>"+  
               "     <desc>管理</desc>"+  
                "</role>"+  
            "</student>";  
        Student student = JaxbUtil.converyToJavaBean(str, Student.class);  
        System.out.println(student);  
    }  

}
