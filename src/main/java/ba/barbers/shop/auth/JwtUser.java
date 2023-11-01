package ba.barbers.shop.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * JWTUser class.
 */

@Getter
@Setter
@SuppressWarnings("checkstyle:ParameterNumber")
public class JwtUser implements UserDetails {

  private Long id;
  private String username;
  private String firstname;
  private String lastname;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;
  private boolean enabled;
  private String tipKorisnika;
  private String tipKorisnikaSifra;

  public JwtUser() {
  }

  public JwtUser(
      final Long id,
      final String username,
      final String firstname,
      final String lastname,
      final String password,
      final Boolean enabled,
      final Collection<? extends GrantedAuthority> authorities,
      final String tipKorisnika,
      final String tipKorisnikaSifra
  ) {
    this.id = id;
    this.username = username;
    this.firstname = firstname;
    this.lastname = lastname;
    this.password = password;
    this.authorities = authorities;
    this.enabled = enabled;
    this.tipKorisnika = tipKorisnika;
    this.tipKorisnikaSifra = tipKorisnikaSifra;
  }

  public String getTipKorisnika() {
    return tipKorisnika;
  }

  @JsonIgnore
  public Long getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @JsonIgnore
  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

}