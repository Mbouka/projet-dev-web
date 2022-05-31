package com.projetWeb.citwe.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FactureDto {
    private String consoEau;
    private  String consoElectricite;
    private String prix;
    private String date;
    private String delai;
}
