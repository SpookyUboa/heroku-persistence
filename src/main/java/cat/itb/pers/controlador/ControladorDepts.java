package cat.itb.pers.controlador;

import cat.itb.pers.model.Departament;
import cat.itb.pers.model.Empleat;
import cat.itb.pers.servei.ServeiDepartaments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorDepts {

    @Autowired
    private ServeiDepartaments servei;

    @GetMapping("/departaments/list")
    public String llistar(Model m) {
        m.addAttribute("llistaDepartaments", servei.llistat());
        return "llistatDept";
    }

    @GetMapping("/departaments/new")
    public String afegirDepartament(Model m) {
        m.addAttribute("departamentForm", new Departament());
        return "afegirDept";
    }

    @PostMapping("/departaments/new/submit")
    public String afegirSubmit(@ModelAttribute("departamentForm") Departament dept) {
        servei.afegir(dept);
        return "redirect:/departaments/list";
    }

    @GetMapping("/departaments/edit/{id}")
    public String editarDepartament(@PathVariable("id") int n, Model m) {
        Departament dept = servei.consultaPerId(n);
        m.addAttribute("departamentForm", dept);
        return "afegirDept";
    }

    @PostMapping("/departaments/edit/submit")
    public String editarDepartamentSubmit(@ModelAttribute("departamentForm") Departament d) {
        servei.substituir(d);
        return "redirect:/departaments/list";
    }

    @GetMapping("/departaments/eliminar")
    public String eliminarDepartament(@RequestParam("id") int n) {
        servei.eliminaPerId(n);
        return "redirect:/departaments/list";
    }
}
