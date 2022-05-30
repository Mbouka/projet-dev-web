package com.projetWeb.citwe.model.service;

import com.projetWeb.citwe.model.dto.FactureDto;
import com.projetWeb.citwe.model.entities.Facture;
import com.projetWeb.citwe.model.mapper.FactureMapper;
import com.projetWeb.citwe.model.repository.FactureRepository;
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
public class FactureService {
    private final FactureRepository repository;
    private final FactureMapper factureMapper;
    @Autowired
    FactureMapper factureMapper;
    @Autowired
    FactureRepository factureRepository;

    /*public FactureService(FactureRepository repository, FactureMapper factureMapper) {
        this.repository = repository;
        this.factureMapper = factureMapper;
    }
*/
    public FactureDto save(FactureDto factureDto) {
        Facture entity = factureMapper.toEntity(factureDto);
        return factureMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public FactureDto findById(String id) {
        return factureMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<FactureDto> findByCondition(FactureDto factureDto, Pageable pageable) {
        Page<Facture> entityPage = repository.findAll(pageable);
        List<Facture> entities = entityPage.getContent();
        return new PageImpl<>(factureMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public FactureDto update(FactureDto factureDto, String id) {
        FactureDto data = findById(id);
        Facture entity = factureMapper.toEntity(factureDto);
        BeanUtil.copyProperties(data, entity);
        return save(factureMapper.toDto(entity));
    }
}