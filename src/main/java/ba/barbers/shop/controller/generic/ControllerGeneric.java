package ba.barbers.shop.controller.generic;

import ba.barbers.shop.entity.generic.BaseEntity;
import ba.barbers.shop.service.generic.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ResponseBody
public class ControllerGeneric<T extends BaseEntity> {

  @Autowired
  private ServiceGeneric<T> genericService;

  @PostMapping("cdnsjd")
  public ResponseEntity<Object> save(@RequestBody T entity) {
    try {
      System.out.println(entity.getClass().getName()+entity.getId());
      return new ResponseEntity(genericService.save(entity), HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity("Error!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping
  public ResponseEntity<T> findAll() {
    try {
      return new ResponseEntity(genericService.findAll(), HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity("Error!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") Long id) {
    try {
      genericService.delete(id);
      return new ResponseEntity("Sucesso ao apagar!", HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity("Erro ao apagar!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}

