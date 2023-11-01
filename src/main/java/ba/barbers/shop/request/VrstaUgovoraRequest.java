package ba.barbers.shop.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VrstaUgovoraRequest {
  private String oznaka;
  private Long sifra;
  private String opis;
}
