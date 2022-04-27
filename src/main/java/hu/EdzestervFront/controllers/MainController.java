package hu.EdzestervFront.controllers;

import hu.EdzestervFront.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @Autowired
    private FelhasznaloService felhasznaloService;
    @Autowired
    private FeladatService feladatService;
    @Autowired
    private CelService celService;
    @Autowired
    private BemutatoService bemutatoService;
    @Autowired
    private JavasoltEdzesService javasoltService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("activemenu", 1);
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/c-felhasznalok")
    public String felhasznalok(Model model){
        model.addAttribute("felhasznalok", felhasznaloService.getFelhasznalok());
        model.addAttribute("activemenu", 2);
        return "felhasznalo";
    }


    @GetMapping("/c-feladatok")
    public String feladatok(Model model){
        model.addAttribute("feladatok", feladatService.getFeladatok());
        model.addAttribute("activemenu", 4);
        return "feladat";
    }

    @GetMapping("/c-feladatleirasok/{id}")
    public String feladatleirasok(@PathVariable("id") int id,
            Model model){
        model.addAttribute("feladatleirasok", feladatService.getFeladat(id));
        model.addAttribute("activemenu", 4);
        return "feladatleiras";
    }

    @GetMapping("/c-celok")
    public String celok(Model model){
        model.addAttribute("celok", celService.getCelok());
        model.addAttribute("activemenu", 5);
        return "cel";
    }

    @GetMapping("/c-bemutatok")
    public String bemutatok(Model model){
        model.addAttribute("bemutatok", bemutatoService.getBemutatok());
        model.addAttribute("activemenu", 6);
        return "bemutato";
    }

    @GetMapping("/c-javasoltak")
    public String javasoltak(Model model){
        model.addAttribute("javasoltak", javasoltService.getJavasoltak());
        model.addAttribute("activemenu", 7);
        return "javasolt";
    }



}
