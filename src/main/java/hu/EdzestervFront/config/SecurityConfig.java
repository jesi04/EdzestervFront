package hu.EdzestervFront.config;

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
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth){   //felhasználónév: admin, jelszó: asdfg
        try {
            auth.inMemoryAuthentication()
                    .withUser("admin").password("$2a$10$DjI.P92vFenHcKMQBb1nKeHqmOnsL/y/6vX4Dcr4Nxl0JO5UaV5xG").roles("USER", "ADMIN")
                    .and()
                    .withUser("user").password("{noop}jklé").roles("USER");
        } catch (Exception ex) {
            System.out.println("ex in configureAuth(): "+ex.getMessage());
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/","/c-feladatleirasok/**", "/c-felhasznalok","/c-edzestervek", "/c-feladatok", "/c-celok", "/c-bemutatok", "/c-javasoltak", "/c-edzesnapok/**","/c-edzesnapfeladatok/**", "/css/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();
    }


}
