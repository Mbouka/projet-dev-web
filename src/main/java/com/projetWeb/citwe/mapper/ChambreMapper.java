package com.projetWeb.citwe.mapper;

import com.projetWeb.citwe.model.Dto.ChambreDto;


import com.projetWeb.citwe.model.entities.Chambre;

import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ChambreMapper {

    Chambre toEntity(ChambreDto chambreDto);

    ChambreDto toDto(Chambre chambre);

    void copy(ChambreDto chambreDto, @MappingTarget Chambre chambre);
}
