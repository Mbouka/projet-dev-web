package com.projetWeb.citwe.serviceImpl;

import com.projetWeb.citwe.mapper.EtudiantMapper;
import com.projetWeb.citwe.model.Dto.EtudiantDto;
import com.projetWeb.citwe.model.entities.Etudiant;
import com.projetWeb.citwe.respository.EtudiantRespository;
import com.projetWeb.citwe.service.Ietudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class etudiantServiceImpl  implements Ietudiant {
    @Autowired
    EtudiantRespository etudiantRespository;
    @Autowired
    EtudiantMapper etudiantMapper;

    @Override
    public int saveEtudiant(EtudiantDto etudiantDto) {
        return etudiantRespository.save(etudiantMapper.toEntity(etudiantDto)).getId().intValue();
    }

    @Override
    public EtudiantDto searchEtudiantByMatricule(String Matricule) {
        return etudiantMapper.toDto(etudiantRespository.findByMatricule(Matricule).get());
    }

    @Override
    public List<EtudiantDto> listEtudiants() {
        return etudiantRespository.findAll().stream()
                .map(etudiantMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EtudiantDto updateEtudiant(EtudiantDto etudiantDto) {
        Etudiant etudiant = etudiantRespository.findByMatricule(etudiantDto.getMatricule()).get();
       etudiantMapper.copy(etudiantDto, etudiant);
        return etudiantMapper.toDto(etudiantRespository.save(etudiant));
    }


}
