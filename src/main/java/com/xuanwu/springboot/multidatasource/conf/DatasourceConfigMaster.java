package com.xuanwu.springboot.multidatasource.conf;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.xuanwu.springboot.multidatasource.dao", sqlSessionTemplateRef  = "testDB1SqlSessionTemplate")
public class DatasourceConfigMaster {
	 	@Bean(name = "mainDatasource")
	    @ConfigurationProperties(prefix = "spring.datasource.testDB1")
	    @Primary
	    public DataSource testDataSource() {
	        return DataSourceBuilder.create().build();
	    }

	    @Bean(name = "testDB1SqlSessionFactory")
	    @Primary
	    public SqlSessionFactory testSqlSessionFactory(@Qualifier("mainDatasource") DataSource dataSource) throws Exception {
	        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
	        bean.setDataSource(dataSource);
	        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappings/*.xml"));
	        return bean.getObject();
	    }

	    @Bean(name = "testDB1TransactionManager")
	    @Primary
	    public DataSourceTransactionManager testTransactionManager(@Qualifier("mainDatasource") DataSource dataSource) {
	        return new DataSourceTransactionManager(dataSource);
	    }

	    @Bean(name = "testDB1SqlSessionTemplate")
	    @Primary
	    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("testDB1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
	        return new SqlSessionTemplate(sqlSessionFactory);
	    }

}
