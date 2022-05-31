package com.projetWeb.citwe.mapper;

import com.projetWeb.citwe.model.Dto.ChambreDto;

import com.projetWeb.citwe.model.entities.Chambre;
/* org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;*/
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ChambreMapper {
    Chambre toEntity(ChambreDto chambreDto);
    ChambreDto toDto(Chambre chambre);

}
