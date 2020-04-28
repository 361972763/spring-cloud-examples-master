package com.peterwanghao.spring.cloud.oauth.authresource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

 /**
  * @description:资源配置
  * @author: clj
  * @date: 15:22 24/04/2019
  * @version : V1.0
  */
@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true) // Allow method annotations like @PreAuthorize
public class ResourceConfigurer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //取消basic认证
        http.httpBasic().disable();
        //任何资源均需要授权
        http.authorizeRequests().antMatchers("/aa").permitAll().anyRequest().authenticated();
    }

}
