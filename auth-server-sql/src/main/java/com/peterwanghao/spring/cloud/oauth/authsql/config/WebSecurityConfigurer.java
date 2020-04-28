package com.peterwanghao.spring.cloud.oauth.authsql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import com.peterwanghao.spring.cloud.oauth.authsql.repository.AccountRepository;
import com.peterwanghao.spring.cloud.oauth.authsql.service.AccountUserDetailsService;

 /**
  * @description:web安全配置
  * @author: clj
  * @date: 8:12 26/04/2019
  * @version : V1.0
  */
@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Autowired
	private AccountRepository accountRepository;

	/**
	* @author clj
	* @description //资源访问路径配置
	* @date 11:41 26/04/2019
	* @param [http]
	* @return void
	**/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//除了login开头之外的都需要认证
		http.authorizeRequests().antMatchers("/login**").permitAll().anyRequest().authenticated().and().csrf().and()
				.formLogin().loginPage("/login");
	}

	/**
	* @author 用户认证
	* @description //TODO
	* @date 11:45 26/04/2019
	* @param [auth]
	* @return void
	**/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceBean());
	}

	/**
	* @author clj 
	* @description //制定账户信息
	* @date 11:44 26/04/2019
	* @param [] 
	* @return org.springframework.security.core.userdetails.UserDetailsService 
	**/
	@Override
	@Bean(name = "userDetailsService")
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new AccountUserDetailsService(accountRepository);
	}

}
