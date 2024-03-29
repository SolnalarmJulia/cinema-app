package spring.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.model.Role;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register", "/login").permitAll()
                .antMatchers(HttpMethod.GET,
                        "/cinema-halls",
                        "/movie-sessions/available",
                        "/movies",
                        "/movie-sessions/{id}").hasAnyRole(Role.RoleName.ADMIN.toString(),
                        Role.RoleName.USER.toString())
                .antMatchers(HttpMethod.POST,
                        "/cinema-halls",
                        "/movies",
                        "/movie-sessions").hasRole(Role.RoleName.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/users/by-email")
                .hasRole(Role.RoleName.ADMIN.toString())
                .antMatchers(HttpMethod.PUT, "/movie-sessions/{id}")
                .hasRole(Role.RoleName.ADMIN.toString())
                .antMatchers(HttpMethod.DELETE, "/movie-sessions/{id}")
                .hasRole(Role.RoleName.ADMIN.toString())
                .antMatchers(HttpMethod.GET,
                        "/orders", "/shopping-carts/by-user")
                .hasRole(Role.RoleName.USER.toString())
                .antMatchers(HttpMethod.POST, "/orders/complete")
                .hasRole(Role.RoleName.USER.toString())
                .antMatchers(HttpMethod.PUT, "/shopping-carts/movie-sessions")
                .hasRole(Role.RoleName.USER.toString())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                 .permitAll()
                .and()
                 .httpBasic()
                .and()
                .csrf().disable();
    }
}
