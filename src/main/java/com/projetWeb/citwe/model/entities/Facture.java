package com.projetWeb.citwe.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "facture")
public class Facture {
    @Id

    @Column(name = "idfacture", nullable = false)
    private Long id;

    @Column(name = "consoEau", nullable = false, length = 50)
    private String consoEau;

    @Column(name = "consoElectricite", nullable = false, length = 50)
    private String consoElectricite;

    @Column(name = "prix", nullable = false, length = 50)
    private String prix;

    @Column(name = "date", nullable = false, length = 50)
    private String date;

    @Column(name = "delai", nullable = false, length = 50)
    private String delai;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_chambre", nullable = false)
    private Chambre idChambre;

    @Column(name = "numFacture", nullable = false, length = 50)
    private String numFacture;




    public Chambre getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Chambre idChambre) {
        this.idChambre = idChambre;
    }

    public String getDelai() {
        return delai;
    }

    public void setDelai(String delai) {
        this.delai = delai;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getConsoElectricite() {
        return consoElectricite;
    }

    public void setConsoElectricite(String consoElectricite) {
        this.consoElectricite = consoElectricite;
    }

    public String getConsoEau() {
        return consoEau;
    }

    public void setConsoEau(String consoEau) {
        this.consoEau = consoEau;
    }

    public String getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(String numFacture) {
        this.numFacture = numFacture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}