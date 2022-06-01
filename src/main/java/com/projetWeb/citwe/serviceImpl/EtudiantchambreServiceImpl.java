package com.projetWeb.citwe.serviceImpl;

import com.projetWeb.citwe.mapper.ChambreMapper;
import com.projetWeb.citwe.mapper.EtudiantchambreMapper;
import com.projetWeb.citwe.model.Dto.ChambreDto;
import com.projetWeb.citwe.model.Dto.EtudiantchambreDto;
import com.projetWeb.citwe.model.entities.Etudiantchambre;
import com.projetWeb.citwe.respository.ChambreRespository;
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

    @Autowired
    ChambreRespository chambreRespository;
    @Autowired
    ChambreMapper chambreMapper;
    @Override
    public int saveEtudiantChambre(EtudiantchambreDto etudiantchambreDto) {
        return  etudiantchambreRespository.save(etudiantchambreMapper.toEntity(etudiantchambreDto)).getId().getIdChambre().intValue();
    }

    @Override
    public EtudiantchambreDto searchEtudiantByIdOrIdchambre(String id1, String id2) {
        return etudiantchambreMapper.toDto(etudiantchambreRespository.findByIdOrIdChambre(id1,id2).get());
    }

    @Override
    public EtudiantchambreDto searchEtudiantChambreByNumero(String numero) {

        return etudiantchambreMapper.toDto(etudiantchambreRespository.findByIdChambre(chambreRespository.findChambreByNumero(numero).get()).get());


    }

    @Override
    public List<EtudiantchambreDto> listEtudiantschambres() {
        return etudiantchambreRespository.findAll().stream()
                .map(etudiantchambreMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public EtudiantchambreDto updateEtudiantChambre(EtudiantchambreDto etudiantchambreDto) {

      Etudiantchambre etudiantchambre = etudiantchambreRespository.findByIdChambre(chambreRespository.findChambreByNumero(etudiantchambreDto.getIdChambre().getNumero()).get()).get();
        etudiantchambreMapper.copy(etudiantchambreDto, etudiantchambre);
        return etudiantchambreMapper.toDto(etudiantchambreRespository.save(etudiantchambre));

    }

}