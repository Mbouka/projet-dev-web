package com.projetWeb.citwe.serviceImpl;

import com.projetWeb.citwe.mapper.ReclamationMapper;
import com.projetWeb.citwe.model.Dto.ReclamationDto;
import com.projetWeb.citwe.respository.ReclamationRespository;
import com.projetWeb.citwe.service.Ireclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class reclamationServiceImpl implements Ireclamation {
    @Autowired
    ReclamationMapper reclamationMapper;
    @Autowired
    ReclamationRespository reclamationRespository;
    @Override
    public int save(ReclamationDto reclamationDto) {
         return reclamationRespository.save(reclamationMapper.toEntity(reclamationDto)).getIdReclamation().intValue();
    }

    @Override
    public List<ReclamationDto> listReclamations() {
        return  reclamationRespository.findAll().stream()
                .map(reclamationMapper::toDto)
                .collect(Collectors.toList());
    }
}
