package cat.itb.pers.controlador;

import cat.itb.pers.model.Empleat;
import cat.itb.pers.servei.ServeiEmpleats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorEmpleats {

    @Autowired
    private ServeiEmpleats servei;

    @GetMapping("/empleats/list")
    public String llistar(Model m) {
        m.addAttribute("llistaEmpleats", servei.llistat());
        return "llistat";
    }

    @GetMapping("/empleats/new")
    public String afegirEmpleat(Model m) {
        m.addAttribute("empleatForm", new Empleat());
        return "afegir";
    }

    @PostMapping("/empleats/new/submit")
    public String afegirSubmit(@ModelAttribute("empleatForm") Empleat emp) {
        servei.afegir(emp);
        return "redirect:/empleats/list";
    }

    @PostMapping("/empleats/edit/submit")
    public String editarSubmit(@ModelAttribute("empleatForm") Empleat emp) {
        servei.substituir(emp);
        return "redirect:/empleats/list";
    }

    @GetMapping("/empleats/edit/{id}")
    public String editarEmpleat(@PathVariable("id") int n, Model m) {
        Empleat emp = servei.consultaPerId(n);
        m.addAttribute("empleatForm", emp);
        return "afegir";
    }

    @GetMapping("/empleats/eliminar")
    public String eliminarEmpleat(@RequestParam("id") int n) {
        servei.eliminaPerId(n);
        return "redirect:/empleats/list";
    }
}
