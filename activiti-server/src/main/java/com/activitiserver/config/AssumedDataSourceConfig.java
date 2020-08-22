package com.activitiserver.config;import com.activitiserver.core.JdbcLocalUserDetailsManager;import org.apache.ibatis.session.SqlSessionFactory;import org.mybatis.spring.SqlSessionFactoryBean;import org.mybatis.spring.SqlSessionTemplate;import org.mybatis.spring.annotation.MapperScan;import org.springframework.beans.factory.annotation.Qualifier;import org.springframework.boot.context.properties.ConfigurationProperties;import org.springframework.boot.jdbc.DataSourceBuilder;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import org.springframework.jdbc.datasource.DataSourceTransactionManager;import javax.sql.DataSource;@Configuration@MapperScan(basePackages = "com.activitiserver.mapper",            sqlSessionFactoryRef = "assumedSqlSessionFactory",            sqlSessionTemplateRef = "assumedSqlSessionTemplate")public class AssumedDataSourceConfig {//    @Resource(name = "assumedDataSource")//    DataSource assumedDataSource;    /**     * 数据源-assumedDataSource     * @return     */    @ConfigurationProperties(prefix = "spring.datasource.assumed")    @Bean(name = "assumedDataSource")    public DataSource assumedDataSource(){        return DataSourceBuilder.create().build();    }    @Bean(name = "assumedSqlSessionFactory")    public SqlSessionFactory assumedSqlSessionFactory(@Qualifier("assumedDataSource") DataSource assumedDataSource) throws Exception{        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();        sqlSessionFactoryBean.setDataSource(assumedDataSource);        return sqlSessionFactoryBean.getObject();    }    @Bean(name = "assumedDataSourceTransactionManager")    public DataSourceTransactionManager assumedDataSourceTransactionManager(@Qualifier("assumedDataSource") DataSource assumedDataSource){        return new DataSourceTransactionManager(assumedDataSource);    }    @Bean(name = "assumedSqlSessionTemplate")    public SqlSessionTemplate assumedSqlSessionTemplate(@Qualifier("assumedSqlSessionFactory") SqlSessionFactory assumedSqlSessionFactory){        return new SqlSessionTemplate(assumedSqlSessionFactory);    }    @Bean(name = "jdbcLocalUserDetailsManager")    public JdbcLocalUserDetailsManager JdbcLocalUserDetailsManager(@Qualifier("assumedDataSource")DataSource assumedDataSource){        JdbcLocalUserDetailsManager jdbcLocalUserDetailsManager = new JdbcLocalUserDetailsManager(assumedDataSource);        return jdbcLocalUserDetailsManager;    }}