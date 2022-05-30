package com.projetWeb.citwe.model.repository;

import com.projetWeb.citwe.model.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, String>, JpaSpecificationExecutor<Etudiant> {
}