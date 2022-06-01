package com.projetWeb.citwe.mapper;

import com.projetWeb.citwe.model.Dto.ChambreDto;
import com.projetWeb.citwe.model.Dto.EtudiantchambreDto;
import com.projetWeb.citwe.model.entities.Chambre;
import com.projetWeb.citwe.model.entities.Etudiantchambre;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EtudiantchambreMapper {
    Etudiantchambre etudiantchambreDtoToEtudiantchambre(EtudiantchambreDto etudiantchambreDto);

    EtudiantchambreDto etudiantchambreToEtudiantchambreDto(Etudiantchambre etudiantchambre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEtudiantchambreFromEtudiantchambreDto(EtudiantchambreDto etudiantchambreDto, @MappingTarget Etudiantchambre etudiantchambre);

    Etudiantchambre toEntity(EtudiantchambreDto etudiantchambreDto);

    EtudiantchambreDto toDto(Etudiantchambre etudiantchambre);
    void copy(EtudiantchambreDto etudiantchambreDto, @MappingTarget Etudiantchambre etudiantchambre);
}
