package com.projetWeb.citwe.respository;

import com.projetWeb.citwe.model.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactureRespository extends JpaRepository<Facture, Long>  {
    Optional<Facture> findFactureByNumFacture(String numFacture);


}
