package ba.barbers.shop.facade;

import static java.util.Map.entry;

import ba.barbers.shop.dto.GenericList;
import ba.barbers.shop.dto.SifraOpis;
import ba.barbers.shop.exception.ResourceNotFoundException;
import ba.barbers.shop.response.IdOpisResponse;
import ba.barbers.shop.response.IzvorSredstavaResponse;
import ba.barbers.shop.response.KomintentOdlukaResponse;
import ba.barbers.shop.response.VrstaUgovoraResponse;
import ba.barbers.shop.service.LOVService;
import ba.barbers.shop.util.SifarnikZaVrstuUgovoraNaziv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LOVFacade {

  /*
  private final LOVService lovService;
  private final Map<SifarnikZaVrstuUgovoraNaziv, Class<? extends SifarnikZaVrstuUgovora>> CLASS_MAP = Map.ofEntries(
      entry(SifarnikZaVrstuUgovoraNaziv.POKRICE_KUPAC, PokriceKupac.class),
      entry(SifarnikZaVrstuUgovoraNaziv.POKRICE_PRODAVAC, PokriceProdavac.class),
      entry(SifarnikZaVrstuUgovoraNaziv.PROCENAT_FINANSIRANJA, ProcenatFinansiranja.class),
      entry(SifarnikZaVrstuUgovoraNaziv.ROK_FINANSIRANJA, RokFinansiranja.class)
  );

  @Autowired
  public LOVFacade(final LOVService lovService) {
    this.lovService = lovService;
  }

  public GenericList<VrstaUgovoraResponse> getListOfValuesVrstaUgovora() {
    return lovService.getListOfValuesVrstaUgovora();
  }

  public GenericList<SifraOpis> getListOfValuesSifarnikZaVrstuUgovora(
      final SifarnikZaVrstuUgovoraNaziv sifarnikZaVrstuUgovoraNaziv,
      final Long vrstaUgovoraId) {
    if (!CLASS_MAP.containsKey(sifarnikZaVrstuUgovoraNaziv)) {
      throw new ResourceNotFoundException("Ne postoji šifarnik za vrstu ugovora sa nazivom " + sifarnikZaVrstuUgovoraNaziv);
    }
    Class<? extends SifarnikZaVrstuUgovora> sifarnikZaVrstuUgovoraClass = CLASS_MAP.get(sifarnikZaVrstuUgovoraNaziv);
    return lovService.getListOfValuesSifarnikZaVrstuUgovora(sifarnikZaVrstuUgovoraClass, vrstaUgovoraId);
  }

  public GenericList<IdOpisResponse> getListOfValuesTipFinansiranja() {
    return lovService.getListOfValuesTipFinansiranja();
  }

  public GenericList<IdOpisResponse> getListOfValuesTipKamate() {
    return lovService.getListOfValuesTipKamate();
  }

  public GenericList<IdOpisResponse> getListOfValuesPlatiteljNaknadeKamate() {
    return lovService.getListOfValuesPlatiteljNaknadeKamate();
  }

  public GenericList<IdOpisResponse> getListOfValuesPlatiteljZatezneKamate() {
    return lovService.getListOfValuesPlatiteljZatezneKamate();
  }

  public GenericList<IzvorSredstavaResponse> getListOfValuesIzvorSredstava() {
    return lovService.getListOfValuesIzvorSredstava();
  }

  public GenericList<KomintentOdlukaResponse> getListOfValuesProdavac() {
    return lovService.getListOfValuesProdavac();
  }

  public GenericList<KomintentOdlukaResponse> getListOfValuesDuznik() {
    return lovService.getListOfValuesDuznik();
  }

  public GenericList<IdOpisResponse> getListOfValuesTipUgovora() {
    return lovService.getListOfValuesTipUgovora();
  }

  public GenericList<IdOpisResponse> getListOfValuesStatus() {
    return lovService.getListOfValuesStatus();
  }

   */
}
