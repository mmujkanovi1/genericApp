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
public class KomintentOdlukaResponse {
  private String komintentSifra;
  private String komintentNaziv;
  private String segmentBanke;
  private String filijalaBanke;
}
