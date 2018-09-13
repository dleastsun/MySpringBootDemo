package com.eai.common.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.eai.common.utils.model.Book;
import com.eai.common.utils.model.Country;
import com.eai.common.utils.model.Province;

public class JaxbTest3 {
	@Test
	public void showMarshaller() {
		Country country = new Country();
		country.setName("中国");

		List<Province> list = new ArrayList<Province>();
		Province province = new Province();
		province.setName("江苏省");
		province.setProvCity("南京市");
		Province province2 = new Province();
		province2.setName("浙江省");
		province2.setProvCity("杭州市");
		list.add(province);
		list.add(province2);

		country.setProvinceList(list);
		
		Book b1=new Book();
		b1.setAuthor("aa");
		b1.setCalendar(new Date());
		b1.setId(111);
		b1.setPrice(1);
		
		Book b2=new Book();
		b2.setAuthor("aa");
		b2.setCalendar(new Date());
		b2.setId(111);
		b2.setPrice(1);
		
		Book [] book=new Book[] {b1,b2};
		country.setBook(book);
		
		String [] strArray= {"11212","2222","3333"};
		country.setStrArray(strArray);
		

		String str = JaxbUtil.convertToXml(country);
		System.out.println(str);
	}

	/** 
	 *  
	 */
	@Test
	public void showUnMarshaller() {
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "<country>"
				+ "    <country_name>中国</country_name>" + "    <provinces>" + "        <province>"
				+ "            <province_name>江苏省</province_name>" + "           <prov_city>南京市</prov_city>"
				+ "        </province>" + "       <province>" + "           <province_name>浙江省</province_name>"
				+ "           <prov_city>杭州市</prov_city>" + "       </province>" + "    </provinces>" + "</country>";
		
		str="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
				"<country>\r\n" + 
				"    <country_name>中国</country_name>\r\n" + 
				"    <provinces>\r\n" + 
				"        <province>\r\n" + 
				"            <province_name>江苏省</province_name>\r\n" + 
				"            <prov_city>南京市</prov_city>\r\n" + 
				"        </province>\r\n" + 
				"        <province>\r\n" + 
				"            <province_name>浙江省</province_name>\r\n" + 
				"            <prov_city>杭州市</prov_city>\r\n" + 
				"        </province>\r\n" + 
				"    </provinces>\r\n" + 
				"    <strArray>11212</strArray>\r\n" + 
				"    <strArray>2222</strArray>\r\n" + 
				"    <book id=\"111\">\r\n" + 
				"        <author>aa</author>\r\n" + 
				"        <calendar>2018-09-13T21:38:54.546+08:00</calendar>\r\n" + 
				"        <price_1>1.0</price_1>\r\n" + 
				"    </book>\r\n" + 
				"</country>";
		str="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
				"<country>\r\n" + 
				"    <country_name>中国</country_name>\r\n" + 
				"    <provinces>\r\n" + 
				"        <province>\r\n" + 
				"            <province_name>江苏省</province_name>\r\n" + 
				"            <prov_city>南京市</prov_city>\r\n" + 
				"        </province>\r\n" + 
				"        <province>\r\n" + 
				"            <province_name>浙江省</province_name>\r\n" + 
				"            <prov_city>杭州市</prov_city>\r\n" + 
				"        </province>\r\n" + 
				"    </provinces>\r\n" + 
				"    <strArray>11212</strArray>\r\n" + 
				"    <strArray>2222</strArray>\r\n" + 
				"    <strArray>3333</strArray>\r\n" + 
				"    <book id=\"111\">\r\n" + 
				"        <author>aa</author>\r\n" + 
				"        <calendar>2018-09-13T21:41:51.051+08:00</calendar>\r\n" + 
				"        <price_1>1.0</price_1>\r\n" + 
				"    </book>\r\n" + 
				"    <book id=\"111\">\r\n" + 
				"        <author>aa</author>\r\n" + 
				"        <calendar>2018-09-13T21:41:51.051+08:00</calendar>\r\n" + 
				"        <price_1>1.0</price_1>\r\n" + 
				"    </book>\r\n" + 
				"</country>";
		Country country = JaxbUtil.converyToJavaBean(str, Country.class);
		System.out.println(country);
	}

}
