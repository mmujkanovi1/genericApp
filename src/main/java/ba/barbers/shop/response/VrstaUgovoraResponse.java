package ba.barbers.shop.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VrstaUgovoraResponse {
  private Long id;
  private String oznaka;
  private Long sifra;
  private String opis;
}
