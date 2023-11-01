package ba.barbers.shop.repository.generic;


import ba.barbers.shop.entity.generic.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}
