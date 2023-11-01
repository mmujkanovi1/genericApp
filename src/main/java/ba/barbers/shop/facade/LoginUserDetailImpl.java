package ba.barbers.shop.facade;

import ba.barbers.shop.entity.generic.User;
import ba.barbers.shop.exception.InvalidUsernameOrPasswordException;
import ba.barbers.shop.auth.util.JwtUserFactory;
import ba.barbers.shop.repository.newrepo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Login Facade.
 */
@Service
@RequiredArgsConstructor
public class LoginUserDetailImpl implements UserDetailsService {

  public static final String SPLIT_STR_CHARACTER = "|";

  private final UserRepository userRepository;


  @Override
  public UserDetails loadUserByUsername(final String username) {
    String userName = username.substring(0, username.indexOf(SPLIT_STR_CHARACTER));
    String password = username.substring(username.indexOf(SPLIT_STR_CHARACTER) + 1);

    List<User> korisniciFaktoring = userRepository.findUserByUsername(userName);
    if (korisniciFaktoring.isEmpty()) {
      throw new InvalidUsernameOrPasswordException("Ne valja korisnicko ime ili password");
    }

    BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();

    for (User fu : korisniciFaktoring) {
      if (bcryptPasswordEncoder.matches(password, fu.getPassword())) {
        return JwtUserFactory.create(fu);
      }
    }

    return null;
  }

}


