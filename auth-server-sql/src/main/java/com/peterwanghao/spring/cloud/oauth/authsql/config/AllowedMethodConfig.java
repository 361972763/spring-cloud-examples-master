package com.peterwanghao.spring.cloud.oauth.authsql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:请求支持get，post
 * @author: clj
 * @date: 16:07 22/04/2019
 * @version : V1.0
 */
@Configuration
public class AllowedMethodConfig {

   @Autowired
   private TokenEndpoint tokenEndpoint;

   @PostConstruct
   public void reconfigure() {
       Set<HttpMethod> allowedMethods =
               new HashSet<>(Arrays.asList(HttpMethod.GET, HttpMethod.POST));
       tokenEndpoint.setAllowedRequestMethods(allowedMethods);
   }
}
