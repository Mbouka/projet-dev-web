package com.projetWeb.citwe.respository;

import com.projetWeb.citwe.model.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRespository extends JpaRepository<Etudiant, Long> {
    /*Optional<Etudiant> findEtudiantByNumChambre(String numero);*/
    Optional<Etudiant> findByMatriculeOrNom(String motcle1, String motcle2);
}
