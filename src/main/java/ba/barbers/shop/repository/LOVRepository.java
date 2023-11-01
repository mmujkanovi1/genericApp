package ba.barbers.shop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LOVRepository {
  /*

  @PersistenceContext
  private EntityManager entityManager;

  private List findAllOrderById(Class entityClass) {
    return entityManager.createQuery("SELECT entity"
            + " FROM " + entityClass.getName() + " entity"
            + " ORDER BY entity.id", entityClass)
        .getResultList();
  }

  private List<Komintent> findAllKomintent() {
    return entityManager.createQuery("SELECT komintent"
                + " FROM " + Komintent.class.getName() + " komintent",
            Komintent.class)
        .getResultList();
  }

  public List<VrstaUgovora> findListOfValuesVrstaUgovora() {
    return findAllOrderById(VrstaUgovora.class);
  }

  public List<? extends SifarnikZaVrstuUgovora> findListOfValuesSifarnikZaVrstuUgovora(
      final Class<? extends SifarnikZaVrstuUgovora> sifarnikZaVrstuUgovoraClass,
      final Long vrstaUgovoraId) {
    return entityManager.createQuery("SELECT sifarnik"
            + " FROM " + sifarnikZaVrstuUgovoraClass.getName() + " sifarnik WHERE sifarnik.id.vrstaUgovora.id = :idVrstaUgovora"
            + " ORDER BY 1", sifarnikZaVrstuUgovoraClass)
        .setParameter("idVrstaUgovora", vrstaUgovoraId)
        .getResultList();
  }

  public List<TipFinansiranja> findListOfValuesTipFinansiranja() {
    return findAllOrderById(TipFinansiranja.class);
  }

  public List<TipKamate> findListOfValuesTipKamate() {
    return findAllOrderById(TipKamate.class);
  }

  public List<PlatiteljNaknadeKamate> findListOfValuesPlatiteljNaknadeKamate() {
    return findAllOrderById(PlatiteljNaknadeKamate.class);
  }

  public List<PlatiteljZatezneKamate> findListOfValuesPlatiteljZatezneKamate() {
    return findAllOrderById(PlatiteljZatezneKamate.class);
  }

  public List<IzvorSredstava> findListOfValuesIzvorSredstava() {
    return entityManager.createQuery("SELECT DISTINCT izvorSredstava FROM " + IzvorSredstava.class.getName() + " izvorSredstava",
            IzvorSredstava.class)
        .getResultList();
  }

  public List<Komintent> findListOfValuesProdavac() {
    return findAllKomintent();
  }

  public List<Komintent> findListOfValuesDuznik() {
    return findAllKomintent();
  }

  public List<TipUgovora> findListOfValuesTipUgovora() {
    return findAllOrderById(TipUgovora.class);
  }

  public List<FactStatus> findListOfValuesStatus() {
    return findAllOrderById(FactStatus.class);
  }

   */
}
