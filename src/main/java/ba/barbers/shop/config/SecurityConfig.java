package ba.barbers.shop.config;

import static org.springframework.security.config.Customizer.withDefaults;

import ba.barbers.shop.auth.JwtAuthorizationTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final AuthenticationProvider authenticationProvider;
  private final BarbersShopBasicAuthenticationEntryPoint authenticationEntryPoint;
  @Value("${security.jwt.header}")
  private String tokenHeader;
  @Value("${path.BarbersShopUrlHttpsFE}")
  private String BarberShopUrlHttpsFE;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .cors(withDefaults())
        // we don't need CSRF because our token is invulnerable
        .csrf().disable()
        // don't create session
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeHttpRequests()
        .requestMatchers("/xsd/**", "/xsl/**", "/api/v1/auth/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**", "/css/**")

        .permitAll()
        .anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(authenticationEntryPoint)
        .and().authenticationProvider(authenticationProvider);
    // Custom JWT based security filter
    JwtAuthorizationTokenFilter authenticationTokenFilter = new JwtAuthorizationTokenFilter(tokenHeader);
    httpSecurity
        .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

    return httpSecurity.build();
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedMethods(CorsConfiguration.ALL)
            .allowedHeaders(CorsConfiguration.ALL)
            .allowedOriginPatterns(BarberShopUrlHttpsFE, "http://localhost:4200");
      }
    };
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web
        .ignoring()
        .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**")
        .requestMatchers(
            HttpMethod.POST,
            "/api/v1/auth/**","/api/v1/user/**");
  }
}
