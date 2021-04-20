package cat.itb.pers.servei;

import cat.itb.pers.database.DeptRepository;
import cat.itb.pers.model.Departament;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class ServeiDepartaments {
    private DeptRepository repositori;

    public ServeiDepartaments(DeptRepository repositori) {
        this.repositori = repositori;
    }

    public void afegir(Departament d) {
        repositori.save(d);
    }

    @PostConstruct
    public void init() {
        repositori.saveAll(Arrays.asList(
                new Departament(10, "Vendes"),
                new Departament(20, "Personal"),
                new Departament(30, "Informàtica")
        ));
    }

    public List<Departament> llistat() {
        return (List<Departament>) repositori.findAll();
    }

    public Departament consultaPerId(int id) {
        for (Departament d : repositori.findAll()) {
            if (d.getDeptId() == id) return d;
        }
        return null;
    }

    public void eliminaPerId(int id) {
        repositori.deleteById(id);
    }

    public void substituir(Departament d) {
        repositori.save(d);
    }
}
