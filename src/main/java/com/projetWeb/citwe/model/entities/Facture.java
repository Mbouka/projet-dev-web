package com.projetWeb.citwe.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Facture {

    @Id
    @Column(name = "id_facture", nullable = false)
    private Long idFacture;

    @Column(name = "idFacture", nullable = false)
public  String Datedebut;
    public String consoElectricite;
    public String  consoEau;
    public String prix;
    public String DateFin;

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }


}
