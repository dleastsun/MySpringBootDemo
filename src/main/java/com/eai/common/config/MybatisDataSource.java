package com.eai.common.config;

import java.util.Properties;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@MapperScan("com.huawei.it.hr.**.dao")
public class MybatisDataSource {
	@Autowired
	private DataSourceProperties dataSourceProperties;

	private final static String mapperLocations = "classpath*:com/huawei/it/hr/**/dao/mapper/*.xml";

	private DruidDataSource pool;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSourceProperties config = dataSourceProperties;
		this.pool = new DruidDataSource();
		this.pool.setDriverClassName(config.getDriverClassName());
		this.pool.setUrl(config.getUrl());
		this.pool.setUsername(config.getUserName());
		// .....
		return this.pool;
	}

	@PreDestroy
	public void close() {
		if (this.pool != null) {
			this.pool.close();
		}
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));

		setPlugins(sqlSessionFactoryBean);

		return sqlSessionFactoryBean.getObject();
	}

	private void setPlugins(SqlSessionFactoryBean sqlSessionFactoryBean) {
		Interceptor pageHelper = getPagerHelperPlugin();
		Interceptor[] interceptors = new Interceptor[] { pageHelper };
		sqlSessionFactoryBean.setPlugins(interceptors);
	}

	private PageInterceptor getPagerHelperPlugin() {
		PageInterceptor pageInterceptor = new PageInterceptor();
		Properties props = new Properties();
		props.setProperty("offsetAsPageNum", "true");
		// ..........
		pageInterceptor.setProperties(props);
		return pageInterceptor;
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSource());
	}

}