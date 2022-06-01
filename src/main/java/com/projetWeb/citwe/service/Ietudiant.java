package com.projetWeb.citwe.service;

import com.projetWeb.citwe.model.Dto.EtudiantDto;
import com.projetWeb.citwe.presentation.Controller.EtudiantController;

import java.util.List;

public interface Ietudiant {

    int saveEtudiant(EtudiantDto etudiantDto);

    EtudiantDto searchEtudiantByMatricule(String Matricule);

    List<EtudiantDto> listEtudiants();
    EtudiantDto updateEtudiant(EtudiantDto etudiantDto);
}
