package com.projetWeb.citwe.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EtudiantDto {
    private String matricule;
    private String nom;
    private  String prenom;
    private String email;
    private String telephone;
}
