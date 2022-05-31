package com.projetWeb.citwe.mapper;

import com.projetWeb.citwe.model.Dto.EtudiantDto;
import com.projetWeb.citwe.model.Dto.FactureIdDto;
import com.projetWeb.citwe.model.entities.Etudiant;
import com.projetWeb.citwe.model.entities.FactureId;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FactureIdMapper {
    FactureId factureIdDtoToFactureId(FactureIdDto factureIdDto);

    FactureId toEntity(FactureIdDto factureIdDto);

    FactureIdDto toDto(FactureId factureId);
    FactureIdDto factureIdToFactureIdDto(FactureId factureId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFactureIdFromFactureIdDto(FactureIdDto factureIdDto, @MappingTarget FactureId factureId);
}
