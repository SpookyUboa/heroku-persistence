package cat.itb.pers.servei;

import cat.itb.pers.database.DeptRepository;
import cat.itb.pers.database.EmpleatRepository;
import cat.itb.pers.model.Departament;
import cat.itb.pers.model.Empleat;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Service
public class ServeiEmpleats {

    private EmpleatRepository repositori;
    private DeptRepository deptRepository;

    public ServeiEmpleats(EmpleatRepository repositori, DeptRepository deptRepository) {
        this.repositori = repositori;
        this.deptRepository = deptRepository;
    }

    public void afegir(Empleat e) {
        repositori.save(e);
    }

    public List<Empleat> llistat() {
        return (List<Empleat>) repositori.findAll();
    }

    @PostConstruct
    public void init() {
        repositori.saveAll(Arrays.asList(
                new Empleat(1, "Edu Romero", "eduardojrl927@gmail.com", "321654987", true, new Departament(10, "Vendes")),
                new Empleat(2, "Jo Bench", "lanzabolos@terra.com", "321654987", false, new Departament(20, "Personal")),
                new Empleat(3, "Nai Palm", "badgrammar@yahoo.es", "321654987", true, new Departament(30, "Informàtica"))
        ));
    }

    public Empleat consultaPerId(int id) {
        for (Empleat e : repositori.findAll()) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public void eliminaPerId(int id) {
        repositori.deleteById(id);
    }

    public void substituir(Empleat e) {
        int deptId = e.getDepartament().getDeptId();
        if (deptRepository.existsById(deptId)) {
            repositori.save(e);
        } else throw new EntityNotFoundException("Department " + deptId + " does not exist.");
    }
}
