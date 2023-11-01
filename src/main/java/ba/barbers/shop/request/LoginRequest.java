package ba.barbers.shop.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
  @Schema(example = "mirza")
  private String username;
  @Schema(example = "mirza")
  private String password;
}