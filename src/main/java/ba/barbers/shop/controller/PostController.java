package ba.barbers.shop.controller;

import ba.barbers.shop.controller.generic.ControllerGeneric;
import ba.barbers.shop.entity.generic.Post;
import ba.barbers.shop.util.Constants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.API_VERSION_PREFIX + "/post")
@Tag(name = "Post")
public class PostController extends ControllerGeneric<Post> {

}
