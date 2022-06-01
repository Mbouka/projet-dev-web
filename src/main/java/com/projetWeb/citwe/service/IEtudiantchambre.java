package com.projetWeb.citwe.service;

import com.projetWeb.citwe.model.Dto.ChambreDto;
import com.projetWeb.citwe.model.Dto.EtudiantDto;
import com.projetWeb.citwe.model.Dto.EtudiantchambreDto;

import java.util.List;

public interface IEtudiantchambre {
    int saveEtudiantChambre(EtudiantchambreDto etudiantchambreDto);

    EtudiantchambreDto searchEtudiantByIdOrIdchambre(String id1 ,String id2);
    EtudiantchambreDto searchEtudiantChambreByNumero(String numero);
    List<EtudiantchambreDto> listEtudiantschambres();
    EtudiantchambreDto updateEtudiantChambre(EtudiantchambreDto etudiantchambreDto);

}
