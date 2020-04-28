package com.peterwanghao.spring.cloud.oauth.authclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.peterwanghao.spring.cloud.oauth.authclient.filters.SimpleFilter;

 /**
  * @description:oauth客户端启动类
  * @author: clj
  * @date: 15:21 24/04/2019
  * @version : V1.0
  */
@SpringBootApplication
public class AuthClient {
	public static void main(String[] args) {
        SpringApplication.run(AuthClient.class, args);
    }    
    
    @Bean
    public SimpleFilter simpleFilter() {
      return new SimpleFilter();
    } 
}
