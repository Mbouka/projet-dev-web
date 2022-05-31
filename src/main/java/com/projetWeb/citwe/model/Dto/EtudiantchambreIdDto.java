package com.projetWeb.citwe.model.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EtudiantchambreIdDto implements Serializable {
    private final Long id;
    private final Long idChambre;
}
