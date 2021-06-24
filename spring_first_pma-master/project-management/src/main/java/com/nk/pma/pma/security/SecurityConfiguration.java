package com.nk.pma.pma.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
        .withDefaultSchema()
        .withUser("user")
            .password("pass")
            .roles("USER")
        .and()
        .withUser("admin")
            .password("pass")
            .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getpasswordencoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    public void configure(HttpSecurity http) throws Exception{
            http.authorizeRequests()
            .antMatchers("/projects/new").hasRole("ADMIN")
            .antMatchers("/employees/new").hasAnyRole("ADMIN")
            .antMatchers("/").authenticated().and().formLogin();


        
          
    }
}
