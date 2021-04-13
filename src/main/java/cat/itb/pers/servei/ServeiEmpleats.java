package cat.itb.pers.servei;

import cat.itb.pers.model.Empleat;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServeiEmpleats {

    private List<Empleat> repositori = new ArrayList<>();

    public void afegir(Empleat e) {
        repositori.add(e);
    }

    public List<Empleat> llistat() {
        return repositori;
    }

    @PostConstruct
    public void init() {
        repositori.addAll(Arrays.asList(
                new Empleat(1, "Edu Romero", "eduardojrl927@gmail.com", "321654987", true),
                new Empleat(2, "Jo Bench", "lanzabolos@terra.com", "321654987", false),
                new Empleat(3, "Nai Palm", "badgrammar@yahoo.es", "321654987", true)
        ));
    }

    public Empleat consultaPerId(int id) {
        for (Empleat emp : repositori) {
            if (emp.getId() == id) return emp;
        }
        return null;
    }

    public void eliminaPerId(int id) {
        repositori.removeIf(emp -> emp.getId() == id);
    }

    public void substituir(Empleat e) {
        for (int i = 0; i < repositori.size(); i++) {
            if (repositori.get(i).getId() == e.getId()) {
                repositori.set(i, e);
                break;
            }
        }
    }
}
