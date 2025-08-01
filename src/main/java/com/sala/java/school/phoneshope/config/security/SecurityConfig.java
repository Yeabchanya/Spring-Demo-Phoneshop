package com.sala.java.school.phoneshope.config.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(
	    prePostEnabled = true,
	    securedEnabled = true,
	    jsr250Enabled = true)
public class SecurityConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// set white list
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/index.html", "/css/**", "/js/**").permitAll()
                //.requestMatchers("/brands").hasRole("SALE")
                
                //.requestMatchers(HttpMethod.POST, "/brands").hasAuthority(PermissionEnum.BRAND_WRITE.getDescription())
                //.requestMatchers(HttpMethod.GET, "/brands").hasAuthority(PermissionEnum.BRAND_READ.getDescription())
                
                .anyRequest().authenticated()
                ).httpBasic(withDefaults());

		return http.build();
	}
	
	@Bean
    public UserDetailsService userDetailsService() {
		
        UserDetails user1 = User.builder()
                .username("dara")
                .password(passwordEncoder.encode("dara123"))
                //.roles("SALE") // will become ROLE_SALE
                .authorities(RoleEnum.SALE.getAuthorities())
                .build();

        UserDetails user2 = User.builder()
                .username("thida")
                .password(passwordEncoder.encode("thida123"))
                //.roles("ADMIN") // will become ROLE_ADMIN
                .authorities(RoleEnum.ADMIN.getAuthorities())
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
