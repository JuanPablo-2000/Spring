package mx.com.gm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Value("${index.saludo}")
    private String saludo;
    
    @GetMapping("/")
    public String inicio(Model model) {
        var mensaje = "Hola Mundo con Thymeleaf";
        log.info("Ejecutando el controlador Spring MVC");
        
        var persona = new Persona();
        
        persona.setNombre("Juan Pablo");
        persona.setApellido("Mera Agudelo");
        persona.setEmail("agudelo@gmail.com");
        persona.setTelefono("55443322");
        
        var persona2 = new Persona();
        
        persona2.setNombre("Karla");
        persona2.setApellido("Gomez");
        persona2.setEmail("gomez@gmail.com");
        persona2.setTelefono("5323322");
        
        /*
        List<Persona> personas = new ArrayList();
        personas.add(persona);
        personas.add(persona2);
        */
        
        var personas = Arrays.asList(persona, persona2);
        
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        
        return "index";
    }
}
