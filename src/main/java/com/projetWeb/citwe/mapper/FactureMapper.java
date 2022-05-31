package com.projetWeb.citwe.mapper;

import com.projetWeb.citwe.model.Dto.FactureDto;
/*import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;*/

import com.projetWeb.citwe.model.entities.Facture;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface FactureMapper {

   Facture toEntity(FactureDto factureDtoO);

    FactureDto toDto(Facture facture);

    void copy(FactureDto factureDto, @MappingTarget Facture facture);
}
