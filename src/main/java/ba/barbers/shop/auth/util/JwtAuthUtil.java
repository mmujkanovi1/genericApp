package ba.barbers.shop.auth.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * JWT Auth Util class.
 */
@Component
@ConfigurationProperties(prefix = "security.jwt")
@Slf4j
public class JwtAuthUtil {
  private static final String ISSUER = "BARBERSSHOP";
  private static String secretKey;
  private static int expireTime;

  @SuppressWarnings("checkstyle:ParameterNumber")
  public static String generateDefaultTokenWithClaims(final String username,
      final Collection<? extends GrantedAuthority> authorities, final String ime,
      final String prezime, final Long id,
      final String tipKorisnika, final String tipKorisnikaSifra) {
    String[] extractedAuthorities = authorities
        .stream()
        .map(GrantedAuthority::getAuthority)
        .toArray(String[]::new);
    String token;
    token = JWT.create().withIssuer(ISSUER).withExpiresAt(Date.from(Instant.now().plus(expireTime, ChronoUnit.MINUTES)))
        .withIssuedAt(new Date())
        .withNotBefore(new Date())
        .withArrayClaim("authorities", extractedAuthorities)
        .withClaim("username", username)
        .withClaim("ime", ime)
        .withClaim("prezime", prezime)
        .withClaim("id", id)
        .withClaim("tipKorisnika", tipKorisnika)
        .withClaim("tipKorisnikaSifra", tipKorisnikaSifra)
        .sign(Algorithm.HMAC256(secretKey));
    return token;
  }

  public static boolean verifyToken(final String sharedSecret, final String token) {
    try {
      final JWTVerifier verifier = JWT.require(Algorithm.HMAC256(sharedSecret)).withIssuer(ISSUER).build();
      verifier.verify(token);
      return true;
    } catch (final Exception e) {
      log.debug("JWTVerifier: Invalid signature/claims, token: " + token + ", error: " + e.getMessage());
      return false;
    }
  }

  public static Map<String, Claim> verifyTokenAndGetClaimsMap(final String token) {
    String jwtToken = token.substring(7); // removes Bearer
    DecodedJWT jwt = null;
    JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).withIssuer(ISSUER).build();
    jwt = verifier.verify(jwtToken);
    if (jwt == null) {
      return null;
    }
    return jwt.getClaims();

  }

  /**
   * Setter for property 'secretKey'.
   *
   * @param secretKey Value to set for property 'secretKey'.
   */
  @Value("${security.jwt.secretKey}")
  public void setSecretKey(final String secretKey) {
    JwtAuthUtil.secretKey = secretKey;
  }

  /**
   * Setter for property 'expireTime'.
   *
   * @param expireTime Value to set for property 'expireTime'.
   */
  @Value("${security.jwt.expireTime}")
  public void setExpireTime(final int expireTime) {
    JwtAuthUtil.expireTime = expireTime;
  }
}
