package hu.EdzestervFront.controllers;

import hu.EdzestervFront.domain.Cel;
import hu.EdzestervFront.domain.Feladat;
import hu.EdzestervFront.domain.Felhasznalo;
import hu.EdzestervFront.services.CelService;
import hu.EdzestervFront.services.FeladatService;
import hu.EdzestervFront.services.FelhasznaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class AdminController {


    @Autowired
    private FelhasznaloService felhasznaloService;
    @Autowired
    private CelService celService;
    @Autowired
    private FeladatService feladatService;

    @GetMapping("/adminfelhasznalo")
    public String newFelhasznalo(Model model){
        model.addAttribute("felhasznalok", felhasznaloService.getFelhasznalok());
        return "adminfelhasznalo";
    }

    @PostMapping("/addfelhasznalo") // űrlapon Add gombot megnyom
    public String addFelhasznalo(
                            @RequestParam("name") String nev,
                            @RequestParam("email") String email,
                            @RequestParam("szuldat") Date szuldat,
                            @RequestParam("magassag") int magassag,
                            @RequestParam("megjegyzes") String megjegyzes,
                            Model model){
        int statusCode = felhasznaloService.addFelhasznalo(nev, email, szuldat, magassag, megjegyzes);
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

    @PostMapping("/update-elerendo_suly") // elerendo_sulyt cserél
    public String updateCel(@RequestParam("id") int id,
                               @RequestParam("megjegyzes") int  elerendo_suly,
                               Model model){
        int status = celService.updateCel(id, elerendo_suly);
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

    @GetMapping("/adminfeladat")
    public String newFeladat(Model model){
        model.addAttribute("feladatok", feladatService.getFeladatok());
        return "adminfeladat";
    }

    @PostMapping("/addfeladat") // űrlapon Add gombot megnyom
    public String addFeladat(
                         @RequestParam("nev") String nev,
                         @RequestParam("elegetettKcal") int elegetettKcal,
                         @RequestParam("leiras") String leiras,
                         @RequestParam("megjegyzes") String megjegyzes,
                         @RequestParam("izomcsoport") String izomcsoport,
                         Model model){
        int statusCode = feladatService.addFeladat(nev, elegetettKcal,leiras,  megjegyzes, izomcsoport);
        model.addAttribute("status", statusCode);
        model.addAttribute("feladatok", feladatService.getFeladatok());
        return "adminfeladat";
    }

    @PostMapping("updatefeladat") // menüpontból navigál
    public String updatingFeladat(@RequestParam("id") int id, Model model){
        Feladat feladat = feladatService.getFeladat(id);
        model.addAttribute("feladat", feladat);
        return "updatefeladat";
    }

    @PostMapping("/update-leiras") // leirast cserél
    public String updateFeladat(@RequestParam("id") int id,
                            @RequestParam("leiras") String  leiras,
                            Model model){
        int status = feladatService.updateFeladat(id, leiras);
        model.addAttribute("status", status);
        model.addAttribute("feladatok", feladatService.getFeladatok());
        return "adminfeladat";
    }

    @PostMapping("/delete-feladat")
    public String deleteFeladat(@RequestParam("id") int id, Model model){
        System.out.println("@DeleteMapping: "+id);
        int status = feladatService.deleteFeladat(id);
        System.out.println("status code: "+status);
        model.addAttribute("status", status);
        model.addAttribute("feladatok", feladatService.getFeladatok());
        return "adminfeladat";
    }


}
