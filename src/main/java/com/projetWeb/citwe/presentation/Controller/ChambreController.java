package com.projetWeb.citwe.presentation.Controller;

import com.projetWeb.citwe.model.Dto.ChambreDto;
import com.projetWeb.citwe.model.Dto.EtudiantchambreDto;
import com.projetWeb.citwe.service.IEtudiantchambre;
import com.projetWeb.citwe.service.Ichambre;
import com.projetWeb.citwe.service.Ietudiant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class ChambreController {
    @Autowired
    Ichambre ichambre;
    @Autowired
    Ietudiant ietudiant;
    @Autowired
    IEtudiantchambre iEtudiantchambre;
    @GetMapping("/listechambre")
    public String pageliste(Model model) {
        //List<ChambreDto> chambreDtos = ichambre.listChambres();
        List<EtudiantchambreDto> etudiantchambreDtos= iEtudiantchambre.listEtudiantschambres();
     //   model.addAttribute("chambreDTOS", chambreDtos);
        model.addAttribute("etudiantchambreDTOS", etudiantchambreDtos);
        return "liste_des_chambres";
    }
}
