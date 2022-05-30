package com.projetWeb.citwe.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reclamation", nullable = false)
    private Long idReclamation;

    public Long getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(Long idReclamation) {
        this.idReclamation = idReclamation;
    }
}
