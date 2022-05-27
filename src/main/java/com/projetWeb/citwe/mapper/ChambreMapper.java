package com.projetWeb.citwe.mapper;
import com.projetWeb.citwe.model.dto.ChambreDTO;
import com.projetWeb.citwe.model.entities.Chambre;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ChambreMapper {

    Chambre toEntity(ChambreDTO chambreDTO);
    ChambreDTO toDto(Chambre chambre);
    void copy(ChambreDTO chambreDTO, @MappingTarget Chambre chambre);
}
