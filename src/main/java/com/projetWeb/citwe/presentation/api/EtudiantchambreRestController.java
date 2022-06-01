package com.projetWeb.citwe.presentation.api;

import com.projetWeb.citwe.model.Dto.EtudiantchambreDto;
import com.projetWeb.citwe.service.IEtudiantchambre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiantchambre")
@Slf4j
public class EtudiantchambreRestController {
    @Autowired
    private IEtudiantchambre iEtudiantchambre;

   @PostMapping(value = "/save")
    public void enregistrerEtudiantchambre(@RequestBody EtudiantchambreDto create) {
        EtudiantchambreRestController.log.info("enregistrer-etudiantchambre");
        iEtudiantchambre.saveEtudiantChambre(create);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EtudiantchambreDto>> getAllEtudiantchambre() {
        return ResponseEntity.ok(iEtudiantchambre. listEtudiantschambres());
    }


    @GetMapping("/{id}/data")
    public ResponseEntity<EtudiantchambreDto> getEtudiantchambre(@PathVariable String id1,String id2){

        return ResponseEntity.ok(iEtudiantchambre.searchEtudiantByIdOrIdchambre(id1,id2));
    }


}
