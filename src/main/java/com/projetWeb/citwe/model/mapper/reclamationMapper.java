package com.projetWeb.citwe.model.mapper;

import com.projetWeb.citwe.model.dto.reclamationDto;
import com.projetWeb.citwe.model.entities.reclamation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface reclamationMapper extends EntityMapper<reclamationDto, reclamation> {
}