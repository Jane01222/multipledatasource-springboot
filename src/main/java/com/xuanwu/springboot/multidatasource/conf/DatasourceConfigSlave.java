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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.xuanwu.springboot.multidatasource.dao2", sqlSessionTemplateRef  = "testDB2SqlSessionTemplate")
public class DatasourceConfigSlave {
	 	@Bean(name = "secondDatasource")
	    @ConfigurationProperties(prefix = "spring.datasource.testDB2")
	    public DataSource testDataSource() {
	        return DataSourceBuilder.create().build();
	    }

	    @Bean(name = "testDB2SqlSessionFactory")
	    public SqlSessionFactory testSqlSessionFactory(@Qualifier("secondDatasource") DataSource dataSource) throws Exception {
	        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
	        bean.setDataSource(dataSource);
	        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappings/*.xml"));
	        return bean.getObject();
	    }

	    @Bean(name = "testDB2TransactionManager")
	    public DataSourceTransactionManager testTransactionManager(@Qualifier("secondDatasource") DataSource dataSource) {
	        return new DataSourceTransactionManager(dataSource);
	    }

	    @Bean(name = "testDB2SqlSessionTemplate")
	    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("testDB2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
	        return new SqlSessionTemplate(sqlSessionFactory);
	    }

}
