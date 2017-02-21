/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.config;

import com.gabi.security.UrlAuthenticationSuccessHandler;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private UrlAuthenticationSuccessHandler urlAuthenticationSuccessHandler;
 
    
    @Bean
    public PasswordEncoder passwordEncoder(){
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder;
    }
    
    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                //.passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select u.username, u.parola, true from users"
                        + " u where u.username=?")
                .authoritiesByUsernameQuery("select u.username, ur.role from users u left join"
                        + " user_roles ur on u.id = ur.users_id"
                        + " where u.username=?");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
        .antMatchers("/resources/**", "/signup", "/test").permitAll() 
        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/medic/**").access("hasRole('ROLE_MEDIC')")
        .antMatchers("/pacient/**").access("hasRole('ROLE_PACIENT')")       
        .and().formLogin().loginPage("/login").successHandler(urlAuthenticationSuccessHandler).failureUrl("/login?error")
        .usernameParameter("username").passwordParameter("parola").permitAll()
        .and().logout().logoutSuccessUrl("/login?")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/access_denied");
    }
    
}
