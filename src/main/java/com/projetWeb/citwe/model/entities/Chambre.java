package com.projetWeb.citwe.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long NumEtudiant;
    private String statut;



}
