package ba.barbers.shop.config;

import ba.barbers.shop.facade.LoginUserDetailImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class JwtAuthConfiguration {

  private final LoginUserDetailImpl jwtUserDetailsService;

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public AuthenticationProvider authenticationProvider() throws Exception {
    DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
    daoAuth.setPasswordEncoder(passwordEncoder());
    daoAuth.setUserDetailsService(userDetailsServiceBean());
    return daoAuth;
  }

  @Bean
  public UserDetailsService userDetailsServiceBean() throws Exception {
    return jwtUserDetailsService;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(10);
  }
}
