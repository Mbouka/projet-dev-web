package com.projetWeb.citwe.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChambreDto {
    private String numero;
    private String statut;
    private String Numchambre;
}
