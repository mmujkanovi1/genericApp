package ba.barbers.shop.auth;


import ba.barbers.shop.auth.util.JwtAuthUtil;
import ba.barbers.shop.auth.util.JwtUserFactory;
import ba.barbers.shop.exception.AuthTokenMissingException;
import com.auth0.jwt.interfaces.Claim;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;

public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private String tokenHeader;

  public JwtAuthorizationTokenFilter(final String tokenHeader) {
    this.tokenHeader = tokenHeader;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    logger.debug("processing authentication for '{}'", request.getRequestURL());

    String authToken = request.getHeader(this.tokenHeader);
    if (authToken == null) {
      throw new AuthTokenMissingException("Authorization header is not present when trying to access protected resource");
    }

    Map<String, Claim> claimMap = JwtAuthUtil.verifyTokenAndGetClaimsMap(authToken);
    JwtUser jwtUser = JwtUserFactory.createFromClaims(claimMap);
    logger.debug("checking authentication for user '{}'", jwtUser);

    UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    logger.info("authorizated user '{}', setting security context", jwtUser.getUsername());
    SecurityContextHolder.getContext().setAuthentication(authentication);

    filterChain.doFilter(request, response);
  }
}
