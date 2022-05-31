package com.projetWeb.citwe.model.Dto;

import com.projetWeb.citwe.model.entities.FactureId;
import lombok.Data;

import java.io.Serializable;

@Data
public class FactureDto implements Serializable {
    private final FactureId id;
}
