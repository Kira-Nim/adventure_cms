package com.adventurealley.adventure_cms.security;

import com.adventurealley.adventure_cms.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsServiceImpl() {
        return new UserDetailsServiceImpl(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()// Vi vil gerne autoiserer hvilke http requests som må finde sted i hele programmet. Hvornår må programmet køre som "normalt"
                .antMatchers("/resources/**", "/static/**", "/css/**", "/images/**", "/activityPage/**", "/","/getActivityEvents/**","/js/**").permitAll() // Alle disse er tilladt når du ikke er logget ind eller er. når du er logget ind er alt ok.
                .anyRequest().authenticated() // Alle andre requests end ovenstående skal man være logget ind for at lave.
                .and()
                .formLogin() // Man logger ind gennem en form i html som man poster fra
                .loginPage("/login") // Den side som der er tale om ligger på denne sti (vi laver den selv i en controler)
                .defaultSuccessUrl("/") // Efter login skal brugeren rediregeres til denne side.
//                .usernameParameter("username") // Når man poster et logind så skal email tolkes som username. Dette bruger man hvis der ikke bare er et username
                .permitAll() // Alle de sider som er nødvendige for at gøre ovenstående skal være lovlige før log-ind
                .and()
                .logout().permitAll() // Der skal være en side man skal logge ud på og denne skal være lovlig
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")); //Den side man logger ud på hedder /logout
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl()).passwordEncoder(passwordEncoder());
    }

// Bruger SpringBoot StarterSequrity
// Note to self: Info from:
// https://technicalsand.com/spring-boot-security-authentication-examples/
// https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt.defaultSuccessUrl("/userMainPage")
// https://stackoverflow.com/questions/38962099/spring-boot-security-redirect-after-successful-login-undefined/40241153

}
