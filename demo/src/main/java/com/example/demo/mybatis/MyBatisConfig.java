package com.example.demo.mybatis;

import java.io.IOException;

import javax.activation.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration 
@MapperScan(basePackages = {"com.example.demo.dao"})
public class MyBatisConfig {
@Bean
public SqlSessionFactory sqlSessionFactory(javax.sql.DataSource dataSoruce) throws Exception{
	SqlSessionFactoryBean ssF = new SqlSessionFactoryBean();
	ssF.setDataSource(dataSoruce);
	PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	ssF.setMapperLocations(resolver.getResources("classpath:com/example/demo/mapper/*.xml"));	
	ssF.setTypeAliasesPackage("com.example.demo.vo");
	return ssF.getObject();
}
//sqlSsessionTemplate
public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
	SqlSessionTemplate ss = new SqlSessionTemplate(sqlSessionFactory);
	return ss;
}
}
