package com.projetWeb.citwe.model.repository;

import com.projetWeb.citwe.model.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long>, JpaSpecificationExecutor<Chambre> {
}