package ba.barbers.shop.controller;

import ba.barbers.shop.facade.LoginFacade;
import ba.barbers.shop.request.LoginRequest;
import ba.barbers.shop.response.LoginResponse;
import ba.barbers.shop.util.Constants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.API_VERSION_PREFIX + "/auth")
@Tag(name = "Login")
public class LoginController {

  private final LoginFacade loginFacade;

  @Autowired
  public LoginController(final LoginFacade loginFacade) {
    this.loginFacade = loginFacade;
  }

  @PostMapping(path = "/logins")
  public ResponseEntity<LoginResponse> login(@RequestBody final LoginRequest loginRequest) {
    return ResponseEntity.status(HttpStatus.OK).body(loginFacade.createToken(loginRequest));
  }

}
