package com.peterwanghao.spring.cloud.oauth.authclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.peterwanghao.spring.cloud.oauth.authclient.filters.SimpleFilter;
 /**
  * @description:启动类
  * @author: clj
  * @date: 15:18 24/04/2019
  * @version : V1.0
  */
@SpringBootApplication
public class AuthZuul {
	public static void main(String[] args) {
        SpringApplication.run(AuthZuul.class, args);
    }    
    
    @Bean
    public SimpleFilter simpleFilter() {
      return new SimpleFilter();
    } 
}
