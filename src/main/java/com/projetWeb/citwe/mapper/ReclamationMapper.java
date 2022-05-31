package com.projetWeb.citwe.mapper;

import com.projetWeb.citwe.model.Dto.ReclamationDto;
import com.projetWeb.citwe.model.entities.Reclamation;
/*import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;*/
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ReclamationMapper {

    Reclamation toEntity(ReclamationDto reclamationDto);

    ReclamationDto toDto(Reclamation reclamation);

    void copy(ReclamationDto reclamationDto, @MappingTarget Reclamation reclamation);
}
