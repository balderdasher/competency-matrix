package com.mrdios.competencymatrix.springboot.example.multidatasource.config;

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

import javax.sql.DataSource;

/**
 * 多数据源配置类
 *
 * @author MrDios
 * @date 2017-08-07
 * @deprecated 暂时注释-不优雅
 */
//@Configuration
//@MapperScan(basePackages = "com.mrdios.competencymatrix.springboot.example.mybatis.xmlmapper", sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class DataSourceConfig {

    /**
     * Create DataSource Bean
     *
     * @return DataSource
     */
    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "spring.dataSource.master")
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * Create SessionFactory bean based on datasource
     *
     * @param dataSource
     * @return SqlSessionFactory
     * @throws Exception
     */
    @Bean(name = "test1SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/mapper/*.xml"));
        return bean.getObject();
    }

    /**
     * Create DataSourceTransactionManager bean based on DataSource
     *
     * @param dataSource
     * @return DataSourceTransactionManager
     */
    @Bean(name = "test1TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * Create SqlSessionTemplate bean based on SqlSessionFactory
     *
     * @param sqlSessionFactory
     * @return SqlSessionTemplate
     * @throws Exception
     */
    @Bean(name = "test1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
