package clase2.demo.controller;

import clase2.demo.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping(value="")
    public String inicio(){
        return "index";
    }

    @GetMapping(value="/NuevaPersona")
    public String nuevaPersona(){
        return "formulario";
    }

    @PostMapping(value="guardarPersona")
    public String guardarPersona(Persona persona, Model model,
                                 @RequestParam("edad") int edad){

        model.addAttribute("persona", persona);
        model.addAttribute("edad",edad);
        System.out.println(edad);
        return "resumen";
    }

}
