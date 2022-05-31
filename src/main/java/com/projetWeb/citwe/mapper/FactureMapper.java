package com.projetWeb.citwe.mapper;

import com.projetWeb.citwe.model.Dto.FactureDto;

import com.projetWeb.citwe.model.entities.Facture;
import org.mapstruct.*;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FactureMapper {
    Facture factureDtoToFacture(FactureDto factureDto);

    FactureDto factureToFactureDto(Facture facture);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFactureFromFactureDto(FactureDto factureDto, @MappingTarget Facture facture);

    FactureDto toDto(Facture facture);
     Facture toEntity (FactureDto factureDto);
}
