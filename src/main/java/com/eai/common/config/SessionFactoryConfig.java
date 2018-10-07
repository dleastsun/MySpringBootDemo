package com.eai.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
/**
 * 
 * @author xudong.li
 *
 */
//@Configuration
//@EnableTransactionManagement
//@MapperScan("com.ntt.coss.apiswext.dao")
public class SessionFactoryConfig implements TransactionManagementConfigurer {
	/** * mybatis ����·�� */
	private static String MYBATIS_CONFIG = "mybatis/mybatis-config.xml";

	@Autowired
	private DataSource dataSource;

	private String typeAliasPackage = "com.ntt.coss.apiswext.dto";

	/**
	 * ����sqlSessionFactoryBean ʵ�� ��������configtion ���շ�����.�ȵ� ����mapper ӳ��·��
	 * ����datasource����Դ
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws Exception { 
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		/** ����mybatis configuration ɨ��·�� */
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
		/** ����datasource */
		sqlSessionFactoryBean.setDataSource(dataSource);
		/** ����typeAlias ��ɨ��·�� */
		sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
		return sqlSessionFactoryBean;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
}