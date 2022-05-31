package com.projetWeb.citwe.service;

import com.projetWeb.citwe.model.Dto.ChambreDto;

import java.util.List;

public interface Ichambre {
    int saveChambre(ChambreDto chambreDto);
    ChambreDto searchChambreNumero(String numero);
    List<ChambreDto> listChambres();
}
