package com.projetWeb.citwe.service;

import com.projetWeb.citwe.model.Dto.ChambreDto;
import com.projetWeb.citwe.model.Dto.FactureDto;
import com.projetWeb.citwe.model.entities.FactureId;

import java.util.List;

public interface Ifacture {

    int saveFacture(FactureDto factureDto);

    FactureDto searchFactureByNumFacture(String numFacture);

    List<FactureDto> listFactures();


}
