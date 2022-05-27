package com.projetWeb.citwe.service;

import com.projetWeb.citwe.model.dto.ChambreDTO;

import java.io.FileNotFoundException;
import java.util.List;

public interface IChambre {
    int saveChambre(ChambreDTO chambreDTO);
    ChambreDTO searchChambreByNumero(String numero);
    List<ChambreDTO> listeChambre();
    List<ChambreDTO> searchChambreByKeyword(String keyword);
    ChambreDTO updateActe(ChambreDTO chambreDTO);
}
