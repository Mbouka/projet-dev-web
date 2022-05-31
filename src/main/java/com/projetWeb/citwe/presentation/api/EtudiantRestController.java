package com.projetWeb.citwe.presentation.api;

import com.projetWeb.citwe.model.Dto.EtudiantDto;
import com.projetWeb.citwe.service.Ietudiant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
@Slf4j
public class EtudiantRestController {

    @Autowired
    private Ietudiant ietudiant;

    @PostMapping(value = "/save")
    public void enregistrerEtudiant(@RequestBody EtudiantDto create) {
        EtudiantRestController.log.info("enregistrer-etudiant");
        ietudiant.saveEtudiant(create);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EtudiantDto>> getAllEtudiant() {
        return ResponseEntity.ok(ietudiant.listEtudiants());
    }


    @GetMapping("/{keyword}/data")
    public ResponseEntity<EtudiantDto> getEtudiant(@PathVariable String keyword1,String keyword2){

        return ResponseEntity.ok(ietudiant.searchEtudiantByMatriculeOrNom(keyword1, keyword2));
    }


}
