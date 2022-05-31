package com.projetWeb.citwe.service;

import com.projetWeb.citwe.model.Dto.EtudiantDto;

import java.util.List;

public interface Ietudiant {

    int saveEtudiant(EtudiantDto etudiantDto);

    EtudiantDto searchEtudiantByMatriculeOrNom(String keyword1,String keyword2);

    List<EtudiantDto> listEtudiants();
}
