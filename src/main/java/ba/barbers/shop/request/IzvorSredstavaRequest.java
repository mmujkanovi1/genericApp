package ba.barbers.shop.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IzvorSredstavaRequest {

  private String izvor;
  private String naziv;

}
