package com.projetWeb.citwe.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "etudiantchambre")
public class Etudiantchambre {
    @EmbeddedId
    private EtudiantchambreId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Etudiant id2;

    @MapsId("idChambre")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_chambre", nullable = false)
    private Chambre idChambre;

    public Chambre getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Chambre idChambre) {
        this.idChambre = idChambre;
    }

    public Etudiant getId2() {
        return id2;
    }

    public void setId2(Etudiant id2) {
        this.id2 = id2;
    }

    public EtudiantchambreId getId() {
        return id;
    }

    public void setId(EtudiantchambreId id) {
        this.id = id;
    }
}