package com.projetWeb.citwe.mapper;

import com.projetWeb.citwe.model.Dto.EtudiantchambreIdDto;
import com.projetWeb.citwe.model.entities.EtudiantchambreId;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EtudiantchambreIdMapper {
    EtudiantchambreId etudiantchambreIdDtoToEtudiantchambreId(EtudiantchambreIdDto etudiantchambreIdDto);

    EtudiantchambreIdDto etudiantchambreIdToEtudiantchambreIdDto(EtudiantchambreId etudiantchambreId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEtudiantchambreIdFromEtudiantchambreIdDto(EtudiantchambreIdDto etudiantchambreIdDto, @MappingTarget EtudiantchambreId etudiantchambreId);
}
