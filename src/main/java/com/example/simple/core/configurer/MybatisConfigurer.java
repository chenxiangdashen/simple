package com.example.simple.core.configurer;

import com.example.simple.core.constant.ProjectConstant;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;

/**
 * @Description: Mybatis翻页插件配置和XML文件配置等
 * @author 张瑶
 * @date 2018/4/18 11:50
 */
@Configuration
public class MybatisConfigurer {

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		factory.setTypeAliasesPackage(ProjectConstant.MODEL_PACKAGE);
		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		return factory.getObject();
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
		mapperScannerConfigurer.setBasePackage(ProjectConstant.MAPPER_PACKAGE);
		return mapperScannerConfigurer;
	}
}
