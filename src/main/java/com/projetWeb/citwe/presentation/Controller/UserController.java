package com.projetWeb.citwe.presentation.Controller;

import com.projetWeb.citwe.service.Ichambre;
import com.projetWeb.citwe.service.Ietudiant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class UserController {
    @Autowired
     Ichambre ichambre;
    @Autowired
    Ietudiant ietudiant;
    @GetMapping("/")
    public String pageAccueil(Model model) {
        //utiliser cette espace pour visualiser l'interface ou vous travailler
      return "indexadmin";
    }
}
