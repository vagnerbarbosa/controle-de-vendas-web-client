package com.websystique.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Bill").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F1").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F2").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F3").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F4").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F5").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F7").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F8").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F9").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F10").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F11").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F12").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F13").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F14").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F15").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F16").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F17").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F18").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F19").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F20").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F21").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("F24").password("123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**", "/vendas", "/controle").access("hasRole('ADMIN')")
                .antMatchers("/db/**","/home").access("hasRole('DBA')")
                .antMatchers("/db/**","/home").access("hasRole('ADMIN')")
                .antMatchers("/controle").access("hasRole('USER')")
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/controle")
                .usernameParameter("ssoId").passwordParameter("password")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied")
                .and().logout();

    }
}
