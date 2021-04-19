package cat.itb.pers.servei;

import cat.itb.pers.model.Departament;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServeiDepartaments {
    private List<Departament> repositori = new ArrayList<>();

    public void afegir(Departament d) {
        repositori.add(d);
    }

    @PostConstruct
    public void init() {
        repositori.addAll(Arrays.asList(
                new Departament(10, "Vendes"),
                new Departament(20, "Personal"),
                new Departament(30, "Informàtica")
        ));
    }

    public List<Departament> llistat() {
        return repositori;
    }

    public Departament consultaPerId(int id) {
        for (Departament d : repositori) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    public void eliminaPerId(int id) {
        repositori.removeIf(dept -> dept.getId() == id);
    }

    public void substituir(Departament d) {
        for (int i = 0; i < repositori.size(); i++) {
            if (repositori.get(i).getId() == d.getId()) {
                repositori.set(i, d);
                break;
            }
        }
    }
}
