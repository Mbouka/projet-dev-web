package com.projetWeb.citwe.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long Numchambre;
    private Long Numcompteureau;
    private Long Numcompteurele;
    private String statut;
}
