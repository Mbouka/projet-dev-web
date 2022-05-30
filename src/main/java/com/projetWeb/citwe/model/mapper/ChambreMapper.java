package com.projetWeb.citwe.model.mapper;

import com.projetWeb.citwe.model.dto.ChambreDto;
import com.projetWeb.citwe.model.entities.Chambre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChambreMapper extends EntityMapper<ChambreDto, Chambre> {
}