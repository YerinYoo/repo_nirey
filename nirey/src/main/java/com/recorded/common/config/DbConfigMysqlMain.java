package com.recorded.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
// MyBatis Mapper 스캔을 위한 설정, com.recorded.infra 패키지의 모든 *dao 인터페이스를 스캔
@MapperScan(basePackages="com.recorded.infra.*",
        sqlSessionFactoryRef="sqlSessionFactoryMysqlMain")
@EnableTransactionManagement
public class DbConfigMysqlMain {

    // DataSource 빈의 이름
    final String datasourceName = "datasourceMysqlMain";

    // application.properties에서 읽어올 prefix 설정
    final String prefixName = "spring.datasource.mysql.main";

    // SqlSessionFactory 빈의 이름
    final String SqlSessionFactoryName = "sqlSessionFactoryMysqlMain";

    // SqlSessionTemplate 빈의 이름
    final String SqlSessionName = "sqlSessionMysqlMain";

    // Primary DataSource 빈 설정
    @Primary
    @Bean(name=datasourceName)
    @ConfigurationProperties(prefix=prefixName)
    public DataSource dataSource() {
        // DataSourceBuilder를 사용하여 DataSource 생성
        return DataSourceBuilder.create().build();
    }

    // Primary SqlSessionFactory 빈 설정
    @Primary
    @Bean(name=SqlSessionFactoryName)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(datasourceName) DataSource datasource
            , ApplicationContext applicationContext) throws Exception{
        // SqlSessionFactoryBean을 생성하고 설정
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        // MyBatis Mapper XML 파일의 위치를 설정
        sqlSessionFactoryBean.setMapperLocations(
                applicationContext.getResources("classpath:/mybatis/mapper/mysql/main/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    // Primary SqlSessionTemplate 빈 설정
    @Primary
    @Bean(name=SqlSessionName)
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        // SqlSessionTemplate 생성 및 설정
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
