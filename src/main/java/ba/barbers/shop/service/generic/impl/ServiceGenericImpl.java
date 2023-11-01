package ba.barbers.shop.service.generic.impl;

import ba.barbers.shop.entity.generic.BaseEntity;
import ba.barbers.shop.entity.generic.User;
import ba.barbers.shop.repository.generic.GenericRepository;
import ba.barbers.shop.service.generic.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceGenericImpl<T extends BaseEntity> implements ServiceGeneric<T> {

  @Autowired
  protected GenericRepository<T> genericRepository;

  @Override
  public List<T> findAll() throws Exception {
    try {
      return genericRepository.findAll();
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public T save(T entity) throws Exception {
    try {
      if(entity instanceof User){

      }
      return genericRepository.save(entity);
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public void delete(Long id) throws Exception {
    try {
      genericRepository.deleteById(id);
    } catch (Exception e) {
      throw e;
    }
  }
}
