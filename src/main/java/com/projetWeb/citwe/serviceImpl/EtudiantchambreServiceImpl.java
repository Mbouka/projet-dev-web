package com.projetWeb.citwe.serviceImpl;

import com.projetWeb.citwe.mapper.EtudiantchambreMapper;
import com.projetWeb.citwe.model.Dto.EtudiantchambreDto;
import com.projetWeb.citwe.respository.EtudiantchambreRespository;
import com.projetWeb.citwe.service.IEtudiantchambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
 public class EtudiantchambreServiceImpl implements IEtudiantchambre {
    @Autowired
    EtudiantchambreRespository etudiantchambreRespository;
    @Autowired
    EtudiantchambreMapper etudiantchambreMapper;


    @Override
    public int saveEtudiantChambre(EtudiantchambreDto etudiantchambreDto) {
        return  etudiantchambreRespository.save(etudiantchambreMapper.toEntity(etudiantchambreDto)).getId().getIdChambre().intValue();
    }

    @Override
    public EtudiantchambreDto searchEtudiantByIdOrIdchambre(String id1, String id2) {
        return etudiantchambreMapper.toDto(etudiantchambreRespository.findByIdOrIdChambre(id1,id2).get());
    }

    @Override
    public List<EtudiantchambreDto> listEtudiantschambres() {
        return etudiantchambreRespository.findAll().stream()
                .map(etudiantchambreMapper::toDto)
                .collect(Collectors.toList());
    }
}