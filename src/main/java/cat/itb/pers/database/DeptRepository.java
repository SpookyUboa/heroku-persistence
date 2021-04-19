package cat.itb.pers.database;

import cat.itb.pers.model.Departament;
import org.springframework.data.repository.CrudRepository;

public interface DeptRepository extends CrudRepository<Departament, Integer> {
}
