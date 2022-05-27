package com.projetWeb.citwe.serviceImpl;

import com.projetWeb.citwe.mapper.ChambreMapper;
import com.projetWeb.citwe.model.dto.ChambreDTO;
import com.projetWeb.citwe.respository.ChambreRespository;
import com.projetWeb.citwe.service.IChambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements IChambre {
    @Autowired
    ChambreRespository chambreRespository;

    @Autowired
    ChambreMapper chambreMapper;

    @Override
    public int saveChambre(ChambreDTO chambreDTO) {
        return 0;
    }

    @Override
    public ChambreDTO searchChambreByNumero(String numero) {
        return null;
    }

    @Override
    public List<ChambreDTO> listeChambre() {
        return null;
    }

    @Override
    public List<ChambreDTO> searchChambreByKeyword(String keyword) {
        return null;
    }

    @Override
    public ChambreDTO updateActe(ChambreDTO chambreDTO) {
        return null;
    }
}
