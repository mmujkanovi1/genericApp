package ba.barbers.shop.controller;

import ba.barbers.shop.controller.generic.ControllerGeneric;
import ba.barbers.shop.entity.generic.Hairstyle;
import ba.barbers.shop.util.Constants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.API_VERSION_PREFIX + "/hairstyle")
@Tag(name = "Hairstyle")
public class HairstyleController extends ControllerGeneric<Hairstyle> {
}
