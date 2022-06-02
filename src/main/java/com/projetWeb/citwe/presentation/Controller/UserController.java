package com.projetWeb.citwe.presentation.controller;

import com.projetWeb.citwe.model.entities.User;
import com.projetWeb.citwe.service.Ichambre;
import com.projetWeb.citwe.service.Ietudiant;
import com.projetWeb.citwe.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
     Ichambre ichambre;
    @Autowired
    Ietudiant ietudiant;
    @GetMapping("/")
    public String pageAccueil(Model model) {
        //utiliser cette espace pour visualiser l'interface ou vous travailler
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final User user = userService.findUserByEmail(auth.getName());
        if(user!= null )
            model.addAttribute("userName", user.getUsername());
        else
            model.addAttribute("");

        return "indexadmin";
    }


}
