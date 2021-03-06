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
@MapperScan(basePackages = "com.xuanwu.springboot.multidatasource.dao3", sqlSessionTemplateRef  = "testDB3SqlSessionTemplate")
public class DatasourceConfigSlave2 {
	 	@Bean(name = "thirdDatasource")
	    @ConfigurationProperties(prefix = "spring.datasource.testDB3")
	    public DataSource testDataSource() {
	        return DataSourceBuilder.create().build();
	    }

	    @Bean(name = "testDB3SqlSessionFactory")
	    public SqlSessionFactory testSqlSessionFactory(@Qualifier("thirdDatasource") DataSource dataSource) throws Exception {
	        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
	        bean.setDataSource(dataSource);
	        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappings/*.xml"));
	        return bean.getObject();
	    }

	    @Bean(name = "testDB3TransactionManager")
	    public DataSourceTransactionManager testTransactionManager(@Qualifier("thirdDatasource") DataSource dataSource) {
	        return new DataSourceTransactionManager(dataSource);
	    }

	    @Bean(name = "testDB3SqlSessionTemplate")
	    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("testDB3SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
	        return new SqlSessionTemplate(sqlSessionFactory);
	    }

}
