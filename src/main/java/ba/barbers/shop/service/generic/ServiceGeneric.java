package ba.barbers.shop.service.generic;

import ba.barbers.shop.entity.generic.BaseEntity;

import java.util.List;

public interface ServiceGeneric <T extends BaseEntity>{

  List<T> findAll() throws Exception;
  T save(T entity) throws Exception;
  void delete(Long id) throws Exception;

}
