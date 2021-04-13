package cat.itb.pers.servei;

import cat.itb.pers.model.Usuari;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServeiUsuaris {
    private List<Usuari> repositori = new ArrayList<>();

    public void afegir(Usuari u) {
        repositori.add(u);
    }

    @PostConstruct
    public void init() {
        repositori.addAll(Arrays.asList(
                new Usuari("edu", passwordEncoder().encode("password67"), "admin"),
                new Usuari("random", passwordEncoder().encode("secret"), "user")
        ));
    }

    public Usuari consultaPerNom(String nom) {
        for (Usuari u : repositori) {
            if (u.getUsername().equals(nom)) return u;
        }
        return null;
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
