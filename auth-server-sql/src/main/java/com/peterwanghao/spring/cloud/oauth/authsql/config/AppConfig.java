package com.peterwanghao.spring.cloud.oauth.authsql.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

 /**
  * @description:数据源配置
  * @author: clj
  * @date: 8:11 26/04/2019
  * @version : V1.0
  */
@Configuration
public class AppConfig {
	@Value("${spring.datasource.url}")
    private String datasourceUrl;
    
    @Value("${spring.database.driverClassName}")
    private String dbDriverClassName;
    
    @Value("${spring.datasource.username}")
    private String dbUsername;
    
    @Value("${spring.datasource.password}")
    private String dbPassword;

    /**
    * @author clj
    * @description //定义数据源
    * @date 11:40 26/04/2019
    * @param []
    * @return javax.sql.DataSource
    **/
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName(dbDriverClassName);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        
        return dataSource;
    }

    /**
    * @author clj
    * @description //指定token存储方式为数据库方式
    * @date 11:40 26/04/2019
    * @param []
    * @return org.springframework.security.oauth2.provider.token.TokenStore
    **/
    @Bean
    public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource());
    }
}
