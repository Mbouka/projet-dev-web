package com.projetWeb.citwe.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Etudiant {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public String nom;
    public String prenom;
    public String  email;
    public String matricule;
    public String  telephone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
