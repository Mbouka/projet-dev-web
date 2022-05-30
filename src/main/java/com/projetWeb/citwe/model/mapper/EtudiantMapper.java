package com.projetWeb.citwe.model.mapper;

import com.projetWeb.citwe.model.dto.EtudiantDto;
import com.projetWeb.citwe.model.entities.Etudiant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtudiantMapper extends EntityMapper<EtudiantDto, Etudiant> {
}