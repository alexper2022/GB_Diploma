package rf.aleksper.diplomproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import rf.aleksper.diplomproject.repositories.UserRepository;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, UserRepository userRepository) throws Exception {
        return http
                .authorizeHttpRequests(reg -> reg
                        .requestMatchers(
                                "/",
                                "/index",
                                "/index/**"
                        ).authenticated()
                        .requestMatchers(
                                "/user/all/**",
                                "/ups/**",
                                "/computer/**",
                                "/monitor/**",
                                "/printer/**"
                        )
                        .hasAnyAuthority("admin", "operator")
                        .requestMatchers("/**").hasAuthority("admin")
                        .anyRequest()
                        .denyAll())
                .logout(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
