package com.startopole.configuration;

import com.startopole.authentication.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
// @EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyDBAuthenticationService myDBAauthenticationService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Users in memory.

        auth.inMemoryAuthentication().withUser("user1").password("12345").roles("USER");
        auth.inMemoryAuthentication().withUser("admin1").password("12345").roles("USER, ADMIN");

        // For User in database.
        auth.userDetailsService(myDBAauthenticationService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // The pages does not require login
        http.authorizeRequests().antMatchers("/", "/index", "/login", "/logout").permitAll();

        // /userInfo page requires login as USER or ADMIN.
        // If no login, it will redirect to /login page.
        //http.authorizeRequests().antMatchers("/userInfo", "panel").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        // For ADMIN only.
        http.authorizeRequests().antMatchers("/adminPanel", "/articles_management", "/newArticle",
                "/editArticle", "/galleries_management", "/newGallery", "/users_management", "/history_management",
                "/newHistory", "/editHistory", "/trainings_management", "/newTraining",
                "/editTraining", "/coaches_management", "/newCoach", "/editCoach", "/members_management",
                "/newMember", "/editMember", "/contact_management", "/newContact", "/editContact", "/newMessage",
                "/fencerDetails").access("hasRole('ROLE_ADMIN')");

        // For USER only.
        http.authorizeRequests().antMatchers("/userPanel").access("hasRole('ROLE_USER')");

        // For COACH only.
        http.authorizeRequests().antMatchers("/coachPanel", "/newCoachMessage",
                 "/coachFencerDetails").access("hasRole('ROLE_COACH')");

        // For ADMIN and COACH
        http.authorizeRequests().antMatchers("/events_management","/newEvent",
                "/editEvent").access("hasAnyRole('ROLE_ADMIN','ROLE_COACH')");

        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will throw.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/panel")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/index");

    }
}