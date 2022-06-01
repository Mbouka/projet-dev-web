package com.projetWeb.citwe.respository;

import com.projetWeb.citwe.model.entities.Chambre;
import com.projetWeb.citwe.model.entities.Etudiant;
import com.projetWeb.citwe.model.entities.Etudiantchambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface EtudiantchambreRespository extends JpaRepository<Etudiantchambre, Long> {
    Optional<Etudiantchambre> findByIdOrIdChambre(String id1, String id2);
    Optional<Etudiantchambre> findByIdChambre(Chambre chambre);
}
