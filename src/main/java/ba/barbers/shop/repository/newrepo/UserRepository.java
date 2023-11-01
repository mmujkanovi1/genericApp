package ba.barbers.shop.repository.newrepo;


import ba.barbers.shop.entity.generic.User;
import ba.barbers.shop.repository.generic.GenericRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends GenericRepository<User> {

  List<User> findUserByUsername(
      @Param("username") String username);

}