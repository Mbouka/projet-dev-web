package com.projetWeb.citwe.presentation.api;

import com.projetWeb.citwe.model.Dto.ChambreDto;
import com.projetWeb.citwe.service.Ichambre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambre")
@Slf4j
public class ChambreRestController {
    @Autowired
    private Ichambre ichambre;

    @PostMapping(value = "/save")
    public void enregistrerChambre(@RequestBody ChambreDto create) {
       ChambreRestController.log.info("enregistrer-acte");
        ichambre.saveChambre(create);
    }

    @GetMapping("/{numero}/data")
    public ResponseEntity<ChambreDto> getRoomsByRooms(@PathVariable String numero){

        return ResponseEntity.ok(ichambre.searchChambreNumero(numero));
    }


    @GetMapping("/all")
    public ResponseEntity<List<ChambreDto>> getAllRooms() {
        return ResponseEntity.ok(ichambre.listChambres());
    }

}
