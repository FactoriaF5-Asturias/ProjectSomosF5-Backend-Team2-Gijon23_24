package org.teamraccoon.dreamfusion.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.teamraccoon.dreamfusion.auth.NoPopupBasicAuthenticationEntryPoint;
import org.teamraccoon.dreamfusion.security.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Value("${api-endpoint}")
	String endpoint;

	JpaUserDetailsService jpaUserDetailsService;

	public SecurityConfiguration(JpaUserDetailsService jpaUserDetailsService) {
		this.jpaUserDetailsService = jpaUserDetailsService;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
				.cors(Customizer.withDefaults())
				.csrf(csrf -> csrf.disable())
				.formLogin(form -> form.disable())
				.authenticationEntryPoint(new NoPopupBasicAuthenticationEntryPoint())
				.logout(out -> out
						.logoutUrl(endpoint + "/logout")
						.deleteCookies("JSESSIONID"))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
						.requestMatchers(HttpMethod.GET, endpoint + "/login").hasAnyRole("USER", "ADMIN")
						.requestMatchers(HttpMethod.POST, endpoint + "/users/register").permitAll()
						.requestMatchers(HttpMethod.GET, endpoint + "/products/**").permitAll()
						.requestMatchers(HttpMethod.GET, endpoint + "/images/**").permitAll()
						.requestMatchers(endpoint + "/products/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, endpoint + "/categories/**").permitAll()
						.requestMatchers(endpoint + "/categories/**").hasRole("ADMIN")
						.anyRequest().authenticated())
				.userDetailsService(jpaUserDetailsService)
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session
						.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

		http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));

		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}