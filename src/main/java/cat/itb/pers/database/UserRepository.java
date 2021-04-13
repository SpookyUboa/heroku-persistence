package cat.itb.pers.database;

import cat.itb.pers.model.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Usuari, String> {

}
