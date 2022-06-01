package com.projetWeb.citwe.respository;

import com.projetWeb.citwe.model.Dto.FactureDto;
import com.projetWeb.citwe.model.entities.Chambre;
import com.projetWeb.citwe.model.entities.Facture;
import com.projetWeb.citwe.model.entities.FactureId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface FactureRespository extends JpaRepository<Facture, Long>  {
    Optional<Facture> findFactureByNumFacture(String numFacture);


}
