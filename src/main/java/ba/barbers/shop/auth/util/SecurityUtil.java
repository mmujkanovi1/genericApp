package ba.barbers.shop.auth.util;

import ba.barbers.shop.auth.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

public final class SecurityUtil {

  private SecurityUtil() {
  }

  public static JwtUser getPrincipal() {
    return ((JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
  }

  public static Collection<? extends GrantedAuthority> getAuthorites() {
    return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
  }

  public static boolean isUserInRole(final String userRole) {
    return SecurityContextHolder
        .getContext()
        .getAuthentication()
        .getAuthorities()
        .stream()
        .anyMatch(a -> a.getAuthority().equals("ROLE_" + userRole));
  }
}

