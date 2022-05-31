package com.projetWeb.citwe.mapper;

import com.projetWeb.citwe.model.Dto.EtudiantDto;
import com.projetWeb.citwe.model.entities.Etudiant;
/*import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;*/

import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface EtudiantMapper {

    Etudiant toEntity(EtudiantDto etudiantDto);

   EtudiantDto toDto(Etudiant etudiant);

    void copy(EtudiantDto etudiantDto, @MappingTarget Etudiant etudiant);
}
