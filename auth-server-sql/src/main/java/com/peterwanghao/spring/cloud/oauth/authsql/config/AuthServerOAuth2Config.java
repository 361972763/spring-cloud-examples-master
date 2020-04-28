package com.peterwanghao.spring.cloud.oauth.authsql.config;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

 /**
  * @description:资源服务器配置
  * @author: clj
  * @date: 8:11 26/04/2019
  * @version : V1.0
  */
@Configuration
@EnableAuthorizationServer
@Order(6)
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {
	private final AuthenticationManager authenticationManager;
    private final AppConfig appConfig;
    
	@Value("${jwt.certificate.store.file}")
	private Resource keystore;

	@Value("${jwt.certificate.store.password}")
	private String keystorePassword;

	@Value("${jwt.certificate.key.alias}")
	private String keyAlias;

	@Value("${jwt.certificate.key.password}")
	private String keyPassword;

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	* @author 制定用户认证方式为数据库认证
	* @description //TODO
	* @date 11:37 26/04/2019
	* @param [authenticationManager, appConfig]
	* @return
	**/
	@Autowired
    public AuthServerOAuth2Config(AuthenticationManager authenticationManager, AppConfig appConfig) {
        this.authenticationManager = authenticationManager;
        this.appConfig = appConfig;
    }
	/**
	* @author clj 
	* @description //TODO
	* @date 11:38 26/04/2019 
	* @param [clients] 
	* @return void 
	**/
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(appConfig.dataSource());
	}
	
	/**
	* @author clj 
	* @description //设置token存储方式
	* @date 11:38 26/04/2019
	* @param [endpoints] 
	* @return void 
	**/
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.accessTokenConverter(jwtAccessTokenConverter()).userDetailsService(userDetailsService);
		endpoints
         .authenticationManager(authenticationManager)
         .tokenStore(appConfig.tokenStore()); // Persist the tokens in the database
	}
	/**
	* @author clj
	* @description //采用Jwt
	* @date 11:39 26/04/2019
	* @param []
	* @return org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
	**/
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(keystore, keystorePassword.toCharArray());
		KeyPair keyPair = keyStoreKeyFactory.getKeyPair(keyAlias, keyPassword.toCharArray());
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setKeyPair(keyPair);
		return converter;
	}
}
