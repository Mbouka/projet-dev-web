package com.projetWeb.citwe.presentation.api;

import com.projetWeb.citwe.model.Dto.FactureDto;
import com.projetWeb.citwe.service.Ifacture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facture")
@Slf4j
public class FactureRestController {
    @Autowired
    private Ifacture ifacture;

    @PostMapping(value = "/saveFacture")
    public void enregistrerFacture(@RequestBody FactureDto create) {
        FactureRestController.log.info("enregistrer-facture");
        ifacture.saveFacture(create);
    }

}
