package com.projetWeb.citwe.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class ChambreDto {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private Long Numchambre;
    private Long Numcompteureau;
    private Long Numcompteurele;
    private String statut;

    public Long getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
