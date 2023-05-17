package com.clockworkjava.kursspring.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;


@Configuration
@EnableWebSecurity
public class SecSecurityConfig  {
  /*  @Autowired
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }*/
  @Bean
  DataSource dataSource() {
      return new EmbeddedDatabaseBuilder()
              .setType(H2)
              .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
              .build();
  }
   /* @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        JdbcDaoImpl jdbcDaoImpl = new JdbcUserDetailsManager(dataSource);
        jdbcDaoImpl.setUsersByUsernameQuery("select username,password,enabled from users where username = ?");
        jdbcDaoImpl.setAuthoritiesByUsernameQuery("select user_name,user_role from roles where user_name = ?");
        return jdbcDaoImpl;

    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService(dataSource()));
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }*/
   @Bean
   UserDetailsManager users(DataSource dataSource) {
       UserDetails user = User.builder()
               .username("user")
               .password(passwordEncoder().encode("pas"))
               .roles("USER")
               .build();
       UserDetails admin = User.builder()
               .username("admin")
               .password(passwordEncoder().encode("pas"))
               .roles("USER", "ADMIN")
               .build();
       JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
       users.createUser(user);
       users.createUser(admin);
       return users;
   }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/knights").hasAnyAuthority("USER","ADMIN")
                        .requestMatchers("/knight").hasAuthority("ADMIN")
                        .requestMatchers("/anonymous*")
                        .anonymous()
                        .requestMatchers("/login*")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                ).formLogin().defaultSuccessUrl("/knights");
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin().disable();

        return http.build();

    }

    private PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }


}
