package com.example.goNotAlone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.
//                authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/registration").permitAll()
//                .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
//                .authenticated().and().csrf().disable().formLogin()
//                .loginPage("/login").failureUrl("/login?error=true")
//                .defaultSuccessUrl("/admin/home")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .and().logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/").and().exceptionHandling()
//                .accessDeniedPage("/access-denied");
        http.authorizeRequests()
                .antMatchers("/user/registration").permitAll()
                .and().httpBasic().and().csrf().disable();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.sql.DataSource;
//
//@EnableWebSecurity
//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Value("${spring.queries.users-query}")
//    private String usersQuery;
//
//    @Value("${spring.queries.roles-query}")
//    private String rolesQuery;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.
//                jdbcAuthentication()
//                .usersByUsernameQuery(usersQuery)
//                .authoritiesByUsernameQuery(rolesQuery)
//                .dataSource(dataSource)
//                .passwordEncoder(bCryptPasswordEncoder);
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//
//                .antMatchers("/user/add").permitAll()
//                .antMatchers("/user/getById").access("hasRole('ADMIN')")
//                .antMatchers("/user/getAll").access("hasRole('ADMIN')")
//                .antMatchers("/user/update").access("hasRole('ADMIN')")
//                .antMatchers("/user/deleteById").access("hasRole('ADMIN')")
//                .antMatchers("/user/deleteAll").access("hasRole('ADMIN')")
//
//                .antMatchers("/event/getAll").access("hasRole('ADMIN')")
//                .antMatchers("/event/getEventById").access("hasRole('ADMIN')")
//                .antMatchers("/event/addApp").access("hasRole('ADMIN')")
//                .antMatchers("/event/update").access("hasRole('ADMIN')")
//                .antMatchers("/event/deleteEvent").access("hasRole('ADMIN')")
//                .antMatchers("/event/deleteAllEvent").access("hasRole('ADMIN')")
//
//                .antMatchers("/place/getAllPlaces").access("hasRole('ADMIN')")
//                .antMatchers("/place/getPlaceById").access("hasRole('ADMIN')")
//                .antMatchers("/place/addPlace").access("hasRole('ADMIN')")
//                .antMatchers("/place/updatePlace").access("hasRole('ADMIN')")
//                .antMatchers("/place/deletePlaceById").access("hasRole('ADMIN')")
//                .antMatchers("/place/deleteAllPlaces").access("hasRole('ADMIN')")
//
//                .antMatchers("/sights/getAllSights").access("hasRole('ADMIN')")
//                .antMatchers("/sights/getSightsById").access("hasRole('ADMIN')")
//                .antMatchers("/sights/addSights").access("hasRole('ADMIN')")
//                .antMatchers("/sights/updateSights").access("hasRole('ADMIN')")
//                .antMatchers("/sights/deleteSightsById").access("hasRole('ADMIN')")
//                .antMatchers("/sights/deleteAllSights").access("hasRole('ADMIN')")
//
//                .and()
//                .httpBasic()
//                .and()
//                .csrf()
//                .disable();
//    }
//}
