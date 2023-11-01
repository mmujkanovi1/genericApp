package ba.barbers.shop.controller;

import ba.barbers.shop.response.IdOpisResponse;
import ba.barbers.shop.response.IzvorSredstavaResponse;
import ba.barbers.shop.response.KomintentOdlukaResponse;
import ba.barbers.shop.response.VrstaUgovoraResponse;
import ba.barbers.shop.util.SifarnikZaVrstuUgovoraNaziv;
import ba.barbers.shop.dto.GenericList;
import ba.barbers.shop.dto.SifraOpis;
import ba.barbers.shop.facade.LOVFacade;
import ba.barbers.shop.util.Constants;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.API_VERSION_PREFIX + "/lov")
@Tag(name = "List Of Values (LOV)")
public class LOVController {

  /*
  private final LOVFacade lovFacade;

  @Autowired
  public LOVController(final LOVFacade lovFacade) {
    this.lovFacade = lovFacade;
  }

  @GetMapping("/vrste-ugovora")
  public ResponseEntity<GenericList<VrstaUgovoraResponse>> getListOfValuesVrstaUgovora() {
    GenericList<VrstaUgovoraResponse> listOfValuesResponse = lovFacade.getListOfValuesVrstaUgovora();
    return ResponseEntity.status(HttpStatus.OK).body(listOfValuesResponse);
  }

  @GetMapping("/sifarnici-za-vrstu-ugovora/{sifarnik-naziv}/{vrsta-ugovora-id}")
  public ResponseEntity<GenericList<SifraOpis>> getListOfValuesSifarnikZaVrstuUgovora(
      @PathVariable(name = "sifarnik-naziv") final SifarnikZaVrstuUgovoraNaziv sifarnikZaVrstuUgovoraNaziv,
      @PathVariable(name = "vrsta-ugovora-id") final Long vrstaUgovoraId) {
    GenericList<SifraOpis> listOfValuesResponse = lovFacade.getListOfValuesSifarnikZaVrstuUgovora(sifarnikZaVrstuUgovoraNaziv, vrstaUgovoraId);
    return ResponseEntity.status(HttpStatus.OK).body(listOfValuesResponse);
  }

  @GetMapping("/tipovi-finansiranja")
  public ResponseEntity<GenericList<IdOpisResponse>> getListOfValuesTipFinansiranja() {
    GenericList<IdOpisResponse> listOfValuesResponse = lovFacade.getListOfValuesTipFinansiranja();
    return ResponseEntity.status(HttpStatus.OK).body(listOfValuesResponse);
  }

  @GetMapping("/tipovi-kamate")
  public ResponseEntity<GenericList<IdOpisResponse>> getListOfValuesTipKamate() {
    GenericList<IdOpisResponse> listOfValuesResponse = lovFacade.getListOfValuesTipKamate();
    return ResponseEntity.status(HttpStatus.OK).body(listOfValuesResponse);
  }

  @GetMapping("/platitelji-naknade-kamate")
  public ResponseEntity<GenericList<IdOpisResponse>> getListOfValuesPlatiteljNaknadeKamate() {
    GenericList<IdOpisResponse> listOfValuesResponse = lovFacade.getListOfValuesPlatiteljNaknadeKamate();
    return ResponseEntity.status(HttpStatus.OK).body(listOfValuesResponse);
  }

  @GetMapping("/platitelji-zatezne-kamate")
  public ResponseEntity<GenericList<IdOpisResponse>> getListOfValuesPlatiteljZatezneKamate() {
    GenericList<IdOpisResponse> listOfValuesResponse = lovFacade.getListOfValuesPlatiteljZatezneKamate();
    return ResponseEntity.status(HttpStatus.OK).body(listOfValuesResponse);
  }


  @GetMapping("/izvori_sredstava")
  public ResponseEntity<GenericList<IzvorSredstavaResponse>> getListOfValuesIzvorSredstava() {
    GenericList<IzvorSredstavaResponse> listOfValuesResponse = lovFacade.getListOfValuesIzvorSredstava();
    return ResponseEntity.status(HttpStatus.OK).body(listOfValuesResponse);
  }

  @GetMapping("/prodavaci")
  public ResponseEntity<GenericList<KomintentOdlukaResponse>> getListOfValuesProdavac() {
    GenericList<KomintentOdlukaResponse> listOfValuesResponse = lovFacade.getListOfValuesProdavac();
    return ResponseEntity.status(HttpStatus.OK).body(listOfValuesResponse);
  }

  @GetMapping("/duznici")
  public ResponseEntity<GenericList<KomintentOdlukaResponse>> getListOfValuesDuznik() {
    GenericList<KomintentOdlukaResponse> listOfValuesResponse = lovFacade.getListOfValuesDuznik();
    return ResponseEntity.status(HttpStatus.OK).body(listOfValuesResponse);
  }

  @GetMapping("/tipovi-ugovora")
  public ResponseEntity<GenericList<IdOpisResponse>> getListOfValuesTipUgovora() {
    GenericList<IdOpisResponse> listOfValuesResponse = lovFacade.getListOfValuesTipUgovora();
    return ResponseEntity.status(HttpStatus.OK).body(listOfValuesResponse);
  }

  @GetMapping("/statusi")
  public ResponseEntity<GenericList<IdOpisResponse>> getListOfValuesStatus() {
    GenericList<IdOpisResponse> listOfValuesResponse = lovFacade.getListOfValuesStatus();
    return ResponseEntity.status(HttpStatus.OK).body(listOfValuesResponse);
  }

   */

}
