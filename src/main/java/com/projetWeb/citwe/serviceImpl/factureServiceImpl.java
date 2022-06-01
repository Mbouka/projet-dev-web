package com.projetWeb.citwe.serviceImpl;


import com.projetWeb.citwe.mapper.FactureMapper;
import com.projetWeb.citwe.model.Dto.FactureDto;
import com.projetWeb.citwe.model.entities.FactureId;
import com.projetWeb.citwe.respository.FactureRespository;
import com.projetWeb.citwe.service.Ifacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class factureServiceImpl implements Ifacture {
    @Autowired
    FactureRespository factureRespository;
    @Autowired
    FactureMapper factureMapper;
    @Override
    public int saveFacture(FactureDto factureDto) {
        return factureRespository.save(factureMapper.toEntity(factureDto)).getId().getIdFacture().intValue();
    }

    @Override
    public FactureDto searchFactureByNumFacture(String numFacture) {
        return factureMapper.toDto(factureRespository. findFactureByNumFacture(numFacture).get());
    }

    @Override
    public List<FactureDto> listFactures() {
        return factureRespository.findAll().stream()
                .map(factureMapper::toDto)
                .collect(Collectors.toList());
    }


}
