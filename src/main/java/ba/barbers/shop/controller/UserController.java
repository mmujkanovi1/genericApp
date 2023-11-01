package ba.barbers.shop.controller;

import ba.barbers.shop.controller.generic.ControllerGeneric;
import ba.barbers.shop.entity.generic.User;
import ba.barbers.shop.util.Constants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.API_VERSION_PREFIX + "/user")
@Tag(name = "User")
public class UserController extends ControllerGeneric<User> {
}
