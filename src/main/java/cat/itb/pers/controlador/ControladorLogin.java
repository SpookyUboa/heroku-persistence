package cat.itb.pers.controlador;

import cat.itb.pers.model.Usuari;
import cat.itb.pers.servei.ServeiUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLogin {

    @Autowired
    private ServeiUsuaris servei;

    @GetMapping("/login")
    public String login(Model m) {
        m.addAttribute("usuari", new Usuari());
        return "login";
    }

    @GetMapping("/register")
    public String register(Model m) {
        m.addAttribute("usuari", new Usuari());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute("usuari") Usuari u){
        servei.afegir(new Usuari(u.getUsername(), passwordEncoder().encode(u.getPassword())));
        return "redirect:/";
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
