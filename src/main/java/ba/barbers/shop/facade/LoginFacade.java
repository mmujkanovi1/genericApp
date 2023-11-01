package ba.barbers.shop.facade;

import ba.barbers.shop.auth.util.JwtAuthUtil;
import ba.barbers.shop.request.LoginRequest;
import ba.barbers.shop.response.LoginResponse;
import ba.barbers.shop.auth.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LoginFacade {

  public static final String SPLIT_STR_CHARACTER = "|";

  private final AuthenticationManager authenticationManager;

  @Autowired
  public LoginFacade(final AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  public LoginResponse createToken(final LoginRequest loginRequest) {

    String username = loginRequest.getUsername();
    String password = loginRequest.getPassword();

    username = username.concat(SPLIT_STR_CHARACTER).concat(password);
    SecurityContextHolder.getContext()
        .setAuthentication(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)));

    return new LoginResponse(JwtAuthUtil
        .generateDefaultTokenWithClaims(SecurityUtil.getPrincipal().getUsername(),
            SecurityContextHolder.getContext().getAuthentication().getAuthorities(),
            SecurityUtil.getPrincipal().getFirstname(),
            SecurityUtil.getPrincipal().getLastname(),
            SecurityUtil.getPrincipal().getId(),
            SecurityUtil.getPrincipal().getTipKorisnika(),
            SecurityUtil.getPrincipal().getTipKorisnikaSifra()));
  }
}
