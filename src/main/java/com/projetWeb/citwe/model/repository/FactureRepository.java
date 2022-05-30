package com.projetWeb.citwe.model.repository;

import com.projetWeb.citwe.model.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, String>, JpaSpecificationExecutor<Facture> {
}