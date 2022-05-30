package com.projetWeb.citwe.model.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.projetWeb.citwe.model.dto.ChambreDto;
import com.projetWeb.citwe.model.entities.Chambre;
import com.projetWeb.citwe.model.mapper.ChambreMapper;
import com.projetWeb.citwe.model.repository.ChambreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ChambreService {
    private final ChambreRepository repository;
    private final ChambreMapper chambreMapper;

    public ChambreService(ChambreRepository repository, ChambreMapper chambreMapper) {
        this.repository = repository;
        this.chambreMapper = chambreMapper;
    }

    public ChambreDto save(ChambreDto chambreDto) {
        Chambre entity = chambreMapper.toEntity(chambreDto);
        return chambreMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ChambreDto findById(String id) {
        return chambreMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ChambreDto> findByCondition(ChambreDto chambreDto, Pageable pageable) {
        Page<Chambre> entityPage = repository.findAll(pageable);
        List<Chambre> entities = entityPage.getContent();
        return new PageImpl<>(chambreMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ChambreDto update(ChambreDto chambreDto, Long id) {
        ChambreDto data = findById(id);
        Chambre entity = chambreMapper.toEntity(chambreDto);
        BeanUtil.copyProperties(data, entity);
        return save(chambreMapper.toDto(entity));
    }
}