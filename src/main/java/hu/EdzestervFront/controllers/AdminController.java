package hu.EdzestervFront.controllers;

import hu.EdzestervFront.domain.Cel;
import hu.EdzestervFront.domain.Felhasznalo;
import hu.EdzestervFront.services.CelService;
import hu.EdzestervFront.services.FelhasznaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {


    @Autowired
    private FelhasznaloService felhasznaloService;
    @Autowired
    private CelService celService;

    @GetMapping("/adminfelhasznalo")
    public String newFelhasznalo(Model model){
        model.addAttribute("felhasznalok", felhasznaloService.getFelhasznalok());
        return "adminfelhasznalo";
    }

    @PostMapping("/addfelhasznalo") // űrlapon Add gombot megnyom
    public String addFelhasznalo(@RequestParam("id") int id,
                            @RequestParam("name") String nev,
                            @RequestParam("email") String email,
                            Model model){
        int statusCode = felhasznaloService.addFelhasznalo(id, nev, email);
        model.addAttribute("status", statusCode);
        model.addAttribute("felhasznalok", felhasznaloService.getFelhasznalok());
        return "adminfelhasznalo";
    }

    @PostMapping("updatefelhasznalo") // menüpontból navigál
    public String updatingFelhasznalo(@RequestParam("id") int id, Model model){
        Felhasznalo felhasznalo = felhasznaloService.getFelhasznalo(id);
        model.addAttribute("felhasznalo", felhasznalo);
        return "updatefelhasznalo";
    }

    @PostMapping("/update-email") // emailt cserél
    public String updateFelhasznalo(@RequestParam("id") int id,
                               @RequestParam("email") String email,
                               Model model){
        int status = felhasznaloService.updateFelhasznalo(id, email);
        model.addAttribute("status", status);
        model.addAttribute("felhasznalok", felhasznaloService.getFelhasznalok());
        return "adminfelhasznalo";
    }

    @PostMapping("/delete-felhasznalo")
    public String deleteFelhasznalo(@RequestParam("id") int id, Model model){
        System.out.println("@DeleteMapping: "+id);
        int status = felhasznaloService.deleteFelhasznalo(id);
        System.out.println("status code: "+status);
        model.addAttribute("status", status);
        model.addAttribute("felhasznalok", felhasznaloService.getFelhasznalok());
        return "adminfelhasznalo";
    }


     @GetMapping("/admincel")
    public String newCel(Model model){
        model.addAttribute("celok", celService.getCelok());
        return "admincel";
    }

    @PostMapping("/addcel") // űrlapon Add gombot megnyom
    public String addCel(@RequestParam("id") int id,
                            @RequestParam("elerendoSuly") int elerendoSuly,
                            @RequestParam("megjegyzes") String megjegyzes,
                            Model model){
        int statusCode = celService.addCel(id, elerendoSuly, megjegyzes);
        model.addAttribute("status", statusCode);
        model.addAttribute("celok", celService.getCelok());
        return "admincel";
    }

    @PostMapping("updatecel") // menüpontból navigál
    public String updatingCel(@RequestParam("id") int id, Model model){
        Cel cel = celService.getCel(id);
        model.addAttribute("cel", cel);
        return "updatecel";
    }

    @PostMapping("/update-elerendoSuly") // elerendoSulyt cserél
    public String updateCel(@RequestParam("id") int id,
                               @RequestParam("megjegyzes") int  elerendoSuly,
                               Model model){
        int status = celService.updateCel(id, elerendoSuly);
        model.addAttribute("status", status);
        model.addAttribute("celok", celService.getCelok());
        return "admincel";
    }

    @PostMapping("/delete-cel")
    public String deleteCel(@RequestParam("id") int id, Model model){
        System.out.println("@DeleteMapping: "+id);
        int status = celService.deleteCel(id);
        System.out.println("status code: "+status);
        model.addAttribute("status", status);
        model.addAttribute("celok", celService.getCelok());
        return "admincel";
    }


}
