package com.tn.configsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("t11")
                .password(new BCryptPasswordEncoder().encode("123456"))
                //pass gửi lên: 123456 => $hvj23h6g27hg2h5hgsfj3hd
                //pass fix: 123456 => $hvj23h6g27hg2h5hgsfj3hd
                .roles("")
                .and()
                .withUser("t12")
                .password(new BCryptPasswordEncoder().encode("112223333"))
                .roles("");

    }
}
