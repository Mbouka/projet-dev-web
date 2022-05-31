package com.projetWeb.citwe.model.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FactureIdDto implements Serializable {
    private final Long idFacture;
    private final Long idChambre;
}
