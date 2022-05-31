package com.projetWeb.citwe.model.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FactureId implements Serializable {
    private static final long serialVersionUID = -4348526235830449667L;
    @Column(name = "id_facture", nullable = false)
    private Long idFacture;
    @Column(name = "id_chambre", nullable = false)
    private Long idChambre;

    public Long getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Long idChambre) {
        this.idChambre = idChambre;
    }

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChambre, idFacture);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FactureId entity = (FactureId) o;
        return Objects.equals(this.idChambre, entity.idChambre) &&
                Objects.equals(this.idFacture, entity.idFacture);
    }
}