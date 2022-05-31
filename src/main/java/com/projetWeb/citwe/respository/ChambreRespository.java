package com.projetWeb.citwe.respository;

import com.projetWeb.citwe.model.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface ChambreRespository extends JpaRepository<Chambre, Long> {
    Optional<Chambre> findChambreByNumero(String numero);


}
