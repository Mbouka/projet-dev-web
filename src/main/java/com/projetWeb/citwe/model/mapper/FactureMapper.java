package com.projetWeb.citwe.model.mapper;

import com.projetWeb.citwe.model.dto.FactureDto;
import com.projetWeb.citwe.model.entities.Facture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FactureMapper extends EntityMapper<FactureDto, Facture> {
}