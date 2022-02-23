package hu.EdzestervFront.controllers;

import hu.EdzestervFront.services.FeladatService;
import hu.EdzestervFront.services.FelhasznaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private FelhasznaloService felhasznaloService;
    @Autowired
    private FeladatService feladatService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("activemenu", 1);
        return "index";
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
        model.addAttribute("activemenu", 3);
        return "feladat";
    }



}
