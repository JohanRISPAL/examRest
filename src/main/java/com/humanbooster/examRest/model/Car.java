package com.humanbooster.examRest.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "La marque ne peut pas être vide !")
    private String marque;

    @Column
    @NotBlank(message = "Le modele ne peut pas être blanc !")
    private String modele;

    @Column
    @NotBlank(message = "Le carburant ne peut pas être blanc !")
    private String carburant;

    @Column
    @NotNull(message = "L'annee ne peut pas être blanc !")
    private Integer annee;

    @Column
    @NotNull(message = "Le kilometrage ne peut pas être blanc !")
    private Integer kilometrage;

    @Column
    @NotNull(message = "Le prix ne peut pas être blanc !")
    private Integer prix;

    @Column
    @NotNull(message = "La description ne peut pas être blanc !")
    private String description;

    public Car() {

    }

    public Car(@NotBlank(message = "La marque ne peut pas être vide !") String marque, @NotBlank(message = "Le modele ne peut pas être blanc !") String modele, @NotBlank(message = "Le carburant ne peut pas être blanc !") String carburant, @NotBlank(message = "L'annee ne peut pas être blanc !") Integer annee, @NotBlank(message = "Le kilometrage ne peut pas être blanc !") Integer kilometrage, @NotBlank(message = "Le prix ne peut pas être blanc !") Integer prix, @NotBlank(message = "La description ne peut pas être blanc !") String description) {
        this.marque = marque;
        this.modele = modele;
        this.carburant = carburant;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.prix = prix;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
