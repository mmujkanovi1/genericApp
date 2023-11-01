package ba.barbers.shop.service.impl;

import ba.barbers.shop.service.LOVService;
import org.springframework.stereotype.Service;

@Service
public class LOVServiceImpl implements LOVService {

  /*
  private final LOVRepository lovRepository;
  private final VrstaUgovoraRepository vrstaUgovoraRepository;

  @Autowired
  public LOVServiceImpl(final LOVRepository lovRepository,
      final VrstaUgovoraRepository vrstaUgovoraRepository) {
    this.lovRepository = lovRepository;
    this.vrstaUgovoraRepository = vrstaUgovoraRepository;
  }

  @Override
  public GenericList<VrstaUgovoraResponse> getListOfValuesVrstaUgovora() {
    List<VrstaUgovora> vrstaUgovoraList = lovRepository.findListOfValuesVrstaUgovora();
    List<VrstaUgovoraResponse> vrstaUgovoraResponseList = VrstaUgovoraMapper.INSTANCE
        .vrstaUgovoraListToVrstaUgovoraResponseList(vrstaUgovoraList);
    return new GenericList<>(vrstaUgovoraResponseList);
  }

  @Override
  public GenericList<SifraOpis> getListOfValuesSifarnikZaVrstuUgovora(final Class<? extends SifarnikZaVrstuUgovora> sifarnikClass,
      final Long vrstaUgovoraId) {
    if (!vrstaUgovoraRepository.existsById(vrstaUgovoraId)) {
      throw new ResourceNotFoundException("Ne postoji vrsta ugovora sa id = " + vrstaUgovoraId);
    }
    List<? extends SifarnikZaVrstuUgovora> sifarnikZaVrstuUgovoraList = lovRepository.findListOfValuesSifarnikZaVrstuUgovora(sifarnikClass,
        vrstaUgovoraId);
    List<SifraOpis> sifraOpisResponseList = SifarnikZaVrstuUgovoraMapper.sifarnikZaVrstuUgovoraListToSifraOpisListAbstract(sifarnikZaVrstuUgovoraList);
    return new GenericList<>(sifraOpisResponseList);
  }

  @Override
  public GenericList<IdOpisResponse> getListOfValuesTipFinansiranja() {
    List<TipFinansiranja> tipFinansiranjaList = lovRepository.findListOfValuesTipFinansiranja();
    List<IdOpisResponse> idOpisResponseList = TipFinansiranjaMapper.INSTANCE.tipFinansiranjaListToIdOpisResponseList(tipFinansiranjaList);
    return new GenericList<>(idOpisResponseList);
  }

  @Override
  public GenericList<IdOpisResponse> getListOfValuesTipKamate() {
    List<TipKamate> tipKamateList = lovRepository.findListOfValuesTipKamate();
    List<IdOpisResponse> idOpisResponseList = TipKamateMapper.INSTANCE.tipKamateListToIdOpisResponseList(tipKamateList);
    return new GenericList<>(idOpisResponseList);
  }

  @Override
  public GenericList<IdOpisResponse> getListOfValuesPlatiteljNaknadeKamate() {
    List<PlatiteljNaknadeKamate> platiteljNaknadeKamateList = lovRepository.findListOfValuesPlatiteljNaknadeKamate();
    List<IdOpisResponse> idOpisResponseList = PlatiteljNaknadeKamateMapper.INSTANCE.platiteljNaknadeKamateListToIdOpisResponseList(platiteljNaknadeKamateList);
    return new GenericList<>(idOpisResponseList);
  }

  @Override
  public GenericList<IdOpisResponse> getListOfValuesPlatiteljZatezneKamate() {
    List<PlatiteljZatezneKamate> platiteljZatezneKamateList = lovRepository.findListOfValuesPlatiteljZatezneKamate();
    List<IdOpisResponse> idOpisResponseList = PlatiteljZatezneKamateMapper.INSTANCE.platiteljZatezneKamateListToIdOpisResponseList(platiteljZatezneKamateList);
    return new GenericList<>(idOpisResponseList);
  }

  @Override
  public GenericList<IzvorSredstavaResponse> getListOfValuesIzvorSredstava() {
    List<IzvorSredstava> izvorKamateList = lovRepository.findListOfValuesIzvorSredstava();
    List<IzvorSredstavaResponse> izvorSredstavaResponseList = IzvorSredstavaMapper.INSTANCE.izvorSredstavaListToIzvorSredstavaResponseList(izvorKamateList);
    return new GenericList<>(izvorSredstavaResponseList);
  }

  @Override
  public GenericList<KomintentOdlukaResponse> getListOfValuesProdavac() {
    List<Komintent> komintentList = lovRepository.findListOfValuesProdavac();
    List<KomintentOdlukaResponse> komintentOdlukaResponseList = KomintentMapper.INSTANCE.komintentListToKomintentOdlukaResponseList(komintentList);
    return new GenericList<>(komintentOdlukaResponseList);
  }

  @Override
  public GenericList<KomintentOdlukaResponse> getListOfValuesDuznik() {
    List<Komintent> komintentList = lovRepository.findListOfValuesDuznik();
    List<KomintentOdlukaResponse> komintentOdlukaResponseList = KomintentMapper.INSTANCE.komintentListToKomintentOdlukaResponseList(komintentList);
    return new GenericList<>(komintentOdlukaResponseList);
  }

  @Override
  public GenericList<IdOpisResponse> getListOfValuesTipUgovora() {
    List<TipUgovora> tipUgovoraList = lovRepository.findListOfValuesTipUgovora();
    List<IdOpisResponse> idOpisResponseList = TipUgovoraMapper.INSTANCE.tipUgovoraListToIdOpisResponseList(tipUgovoraList);
    return new GenericList<>(idOpisResponseList);
  }

  @Override
  public GenericList<IdOpisResponse> getListOfValuesStatus() {
    List<FactStatus> statusList = lovRepository.findListOfValuesStatus();
    List<IdOpisResponse> idOpisResponseList = FactStatusMapper.INSTANCE.statusListToIdOpisResponseList(statusList);
    return new GenericList<>(idOpisResponseList);
  }

   */
}
