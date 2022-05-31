package com.projetWeb.citwe.serviceImpl;

import com.projetWeb.citwe.mapper.ChambreMapper;
import com.projetWeb.citwe.model.Dto.ChambreDto;
import com.projetWeb.citwe.respository.ChambreRespository;
import com.projetWeb.citwe.service.Ichambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class chambreServiceImpl implements Ichambre {
    @Autowired
    ChambreRespository chambreRespository;
    @Autowired
    ChambreMapper chambreMapper;

    @Override
    public int saveChambre(ChambreDto chambreDto) {
        return chambreRespository.save(chambreMapper.toEntity(chambreDto)).getIdChambre().intValue();
    }

    @Override
    public ChambreDto searchChambreNumero(String numero) {
        return chambreMapper.toDto(chambreRespository.findChambreByNumero(numero).get());
    }

    @Override
    public List<ChambreDto> listChambres() {
        return chambreRespository.findAll().stream()
                .map(chambreMapper::toDto)
                .collect(Collectors.toList());
    }
}
