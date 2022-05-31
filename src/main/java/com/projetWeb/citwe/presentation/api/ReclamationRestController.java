package com.projetWeb.citwe.presentation.api;
import com.projetWeb.citwe.model.Dto.EtudiantDto;
import com.projetWeb.citwe.model.Dto.ReclamationDto;
import com.projetWeb.citwe.service.Ireclamation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamation")
@Slf4j
public class ReclamationRestController {
    @Autowired
    private Ireclamation ireclamation;

    @PostMapping(value = "/saveReclamation")
    public void enregistrer(@RequestBody ReclamationDto create) {
        ReclamationRestController.log.info("enregistrer-reclamation");
        ireclamation.save(create);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReclamationDto>> getAllReclamation() {
        return ResponseEntity.ok(ireclamation.listReclamations());
    }

}
