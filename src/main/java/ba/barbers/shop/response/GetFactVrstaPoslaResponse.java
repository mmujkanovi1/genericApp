package ba.barbers.shop.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetFactVrstaPoslaResponse {
  @Schema(description = "FactVrstaPosla id",
      example = "1")
  private Long id;

  @Schema(description = "Opis",
      example = "Primjer opisa")
  private String opis;

  @Schema(description = "Obračun kamate",
      example = "N")
  private Character obracunKamate;
}
