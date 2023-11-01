package ba.barbers.shop.auth.util;


import ba.barbers.shop.auth.JwtUser;
import ba.barbers.shop.entity.generic.User;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JWT User FACTORY.
 */
public final class JwtUserFactory {

  private JwtUserFactory() {
  }

  public static JwtUser create(final User user) {
    return new JwtUser(
        user.getId(),
        user.getUsername(),
        user.getName(),
        user.getSurname(),
        user.getPassword(),
        true,
        mapToGrantedAuthorities(user),
        user.getRole().getName().name(),
        user.getRole().getId().toString()
    );
  }

  public static JwtUser createFromClaims(final Map<String, Claim> claimsMap) {
    return new JwtUser(
        claimsMap.get("id").asLong(),
        claimsMap.get("username").asString(),
        claimsMap.get("ime").asString(),
        claimsMap.get("prezime").asString(),
        null,
        true,
        claimsMap.get("authorities").asList(SimpleGrantedAuthority.class),
        claimsMap.get("tipKorisnika").asString(),
        claimsMap.get("tipKorisnikaSifra").asString()
    );
  }

  private static List<GrantedAuthority> mapToGrantedAuthorities(final User user) {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));
    return authorities;
  }
}