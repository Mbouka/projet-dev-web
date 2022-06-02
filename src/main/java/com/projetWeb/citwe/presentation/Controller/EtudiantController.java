package com.projetWeb.citwe.presentation.controller;
import com.projetWeb.citwe.model.Dto.EtudiantDto;
import com.projetWeb.citwe.model.Dto.EtudiantchambreDto;
import com.projetWeb.citwe.service.IEtudiantchambre;
import com.projetWeb.citwe.service.Ichambre;
import com.projetWeb.citwe.service.Ietudiant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class EtudiantController {
    @Autowired
    Ichambre ichambre;
    @Autowired
    Ietudiant ietudiant;
    @Autowired
    IEtudiantchambre iEtudiantchambre;

    @GetMapping("/detail")
    public String pageDetail(@RequestParam(name = "matricule") String matricule, Model model) {
        EtudiantDto etudiantDto = ietudiant.searchEtudiantByMatricule(matricule);
        model.addAttribute("etudiantDto", etudiantDto);
        return "ProfileChambre";
    }
    //affichage du formulaire d'edition d'un acte
    @GetMapping("/editeretudiantchambreform")
    public String editeretudiantchambreForm(@RequestParam(name = "numero") String numero, Model model) {

        EtudiantchambreDto etudiantchambreDto= iEtudiantchambre.searchEtudiantChambreByNumero(numero);
        model.addAttribute("etudiantchambreDto", etudiantchambreDto);
        return "infoEtudiant";
    }

    @PostMapping("/editeretudiantchambre")
    public String editeretudiant(@ModelAttribute EtudiantchambreDto etudiantchambreDto,
                             Model model) {

        EtudiantController.log.info("editer-etudiant");
        // appel de la couche service ou metier injectée pour enregistrer un materiel
       iEtudiantchambre.updateEtudiantChambre(etudiantchambreDto);
        return "redirect:/ProfilChambre";
    }

}
