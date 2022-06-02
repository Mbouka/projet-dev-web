package com.projetWeb.citwe.service;

import com.projetWeb.citwe.model.Dto.FactureDto;

import java.util.List;

public interface Ifacture {

    int saveFacture(FactureDto factureDto);

    FactureDto searchFactureByNumFacture(String numFacture);

    List<FactureDto> listFactures();


}
