package com.projetWeb.citwe.model.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FactureDto implements Serializable {
    private final Long id;
    private final String consoEau;
    private final String consoElectricite;
    private final String prix;
    private final String date;
    private final String delai;
    private final ChambreDto idChambre;
    private final String numFacture;
}
    private final String numFacture;