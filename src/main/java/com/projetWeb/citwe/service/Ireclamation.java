package com.projetWeb.citwe.service;

import com.projetWeb.citwe.model.Dto.EtudiantDto;
import com.projetWeb.citwe.model.Dto.ReclamationDto;

import java.util.List;

public interface Ireclamation {
    int save (ReclamationDto reclamationDto);
    List<ReclamationDto> listReclamations();
}
