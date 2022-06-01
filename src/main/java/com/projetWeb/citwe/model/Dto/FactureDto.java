package com.projetWeb.citwe.model.Dto;

import com.projetWeb.citwe.model.entities.FactureId;
import lombok.Data;

import java.io.Serializable;

@Data
public class FactureDto  {

    private final FactureId id;
    private String numFacture;
private  String consoEau;
private String consoElectricite;
private String prix;
private String date;
private String delai;
}
