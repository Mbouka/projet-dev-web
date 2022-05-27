package com.projetWeb.citwe.respository;

import com.projetWeb.citwe.model.entities.Chambre;

import java.util.List;
import java.util.Optional;

public interface ChambreRespository {

    Optional<Chambre> findChambreByNumero(String numero);

    Optional<List<Chambre>> findChambreByNumeroOrNom(String motcle1, String motcle2);

    boolean existsByNumeroIgnoreCase(String numero);
}
