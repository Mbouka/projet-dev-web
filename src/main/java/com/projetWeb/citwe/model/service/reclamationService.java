package com.projetWeb.citwe.model.service;

import com.projetWeb.citwe.model.dto.reclamationDto;
import com.projetWeb.citwe.model.entities.reclamation;
import com.projetWeb.citwe.model.mapper.reclamationMapper;
import com.projetWeb.citwe.model.repository.reclamationRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class reclamationService {

@Autowired
reclamationMapper reclamationMapper;
@Autowired
reclamationRepository repository;
   /* public reclamationService(reclamationRepository repository, reclamationMapper reclamationMapper) {
        this.repository = repository;
        this.reclamationMapper = reclamationMapper;
    }
*/
    public reclamationDto save(reclamationDto reclamationDto) {
        reclamation entity = reclamationMapper.toEntity(reclamationDto);
        return reclamationMapper.toDto(repository.save(entity));
    }

   /* public reclamationDto findById(Long id) {
        return reclamationMapper.toDto(repository.findById(id));
    }
*/


}