package com.projetWeb.citwe.model.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EtudiantchambreDto implements Serializable {
    private final EtudiantchambreIdDto id;
    private final EtudiantDto id2;
    private final ChambreDto idChambre;
}
