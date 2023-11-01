package ba.barbers.shop.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class BarbersShopBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

  @Value("${config.realmName}")
  private String realmName;

  @Override
  public void afterPropertiesSet() {
    setRealmName(realmName);
    super.afterPropertiesSet();
  }

  @Override
  public void commence(
      final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authEx)
      throws IOException {
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    PrintWriter writer = response.getWriter();
    writer.println("HTTP Status 401 - " + authEx.getMessage());
  }
}
