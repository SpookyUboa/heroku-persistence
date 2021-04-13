package cat.itb.pers.servei;

import cat.itb.pers.database.UserRepository;
import cat.itb.pers.model.Usuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class ServeiUsuaris {
    @Autowired
    private UserRepository repositori;

    public void afegir(Usuari u) {
        repositori.save(u);
    }

    @PostConstruct
    public void init() {
        repositori.saveAll(Arrays.asList(
                new Usuari("edu", passwordEncoder().encode("password67"), "admin"),
                new Usuari("random", passwordEncoder().encode("secret"), "user")
        ));
    }

    public Usuari consultaPerNom(String nom) {
        for (Usuari u : repositori.findAll()) {
            if (u.getUsername().equals(nom)) return u;
        }
        return null;
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
