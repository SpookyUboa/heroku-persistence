package cat.itb.pers.database;

import cat.itb.pers.model.Empleat;
import org.springframework.data.repository.CrudRepository;

public interface EmpleatRepository extends CrudRepository<Empleat, Integer> {
}
