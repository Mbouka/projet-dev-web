package com.projetWeb.citwe.model.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EtudiantchambreId implements Serializable {
    private static final long serialVersionUID = 6736290281591528944L;
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_chambre", nullable = false)
    private Long idChambre;

    public Long getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Long idChambre) {
        this.idChambre = idChambre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChambre, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EtudiantchambreId entity = (EtudiantchambreId) o;
        return Objects.equals(this.idChambre, entity.idChambre) &&
                Objects.equals(this.id, entity.id);
    }
}