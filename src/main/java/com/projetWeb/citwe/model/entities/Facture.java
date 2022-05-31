package com.projetWeb.citwe.model.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "facture")
public class Facture {
    @EmbeddedId
    private FactureId id;

    public FactureId getId() {
        return id;
    }

    public void setId(FactureId id) {
        this.id = id;
    }
}