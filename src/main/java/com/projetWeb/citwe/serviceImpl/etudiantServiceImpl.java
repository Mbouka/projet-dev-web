package com.projetWeb.citwe.serviceImpl;

import com.projetWeb.citwe.mapper.EtudiantMapper;
import com.projetWeb.citwe.model.Dto.EtudiantDto;
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
    public EtudiantDto searchEtudiantByMatriculeOrNom(String keyword1, String keyword2) {
        return etudiantMapper.toDto(etudiantRespository.findByMatriculeOrNom(keyword1,keyword2).get());
    }

    @Override
    public List<EtudiantDto> listEtudiants() {
        return etudiantRespository.findAll().stream()
                .map(etudiantMapper::toDto)
                .collect(Collectors.toList());
    }


}
