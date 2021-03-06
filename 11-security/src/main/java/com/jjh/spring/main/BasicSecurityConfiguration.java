package com.jjh.spring.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.jjh.spring.controller")
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	public BasicSecurityConfiguration() {
		System.out.println("BasicSecurityConfiguration.<init>()");
	}
 
	// Can also use the following method to set up a custom AuthenticationProvider
	// auth.authenticationProvider(new MyCustomAuthenticationProvider());
	// This must implement the AuthenticationProvider interface
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    	System.out.println("BasicSecurityConfiguration.configure(auth)");
        auth
          .inMemoryAuthentication()
          .withUser("jeh")
            .password("{noop}user123") // Otherwise expects encoded password
            .roles("USER")
            .and()
          .withUser("admin")
            .password("{noop}admin")
            .roles("USER", "ADMIN");
    }

    // Configures URL patterns that are secured

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println("BasicSecurityConfiguration.configure(http)");

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/books/**").access("hasRole('USER')");

    }
}


