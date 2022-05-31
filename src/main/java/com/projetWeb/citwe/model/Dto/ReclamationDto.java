package com.projetWeb.citwe.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReclamationDto {
    private String objet;
    private Long idChambre;
}
