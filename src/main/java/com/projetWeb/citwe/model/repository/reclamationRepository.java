package com.projetWeb.citwe.model.repository;

import com.projetWeb.citwe.model.entities.reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface reclamationRepository extends JpaRepository<reclamation, Long>, JpaSpecificationExecutor<reclamation> {
}