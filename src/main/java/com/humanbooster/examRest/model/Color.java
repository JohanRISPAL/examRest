package com.humanbooster.examRest.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "Le rgv ne peut pas être vide !")
    private String codergv;

    @Column
    @NotBlank(message = "Le libelle ne peut pas être blanc !")
    private String libelle;

    public Color(){

    }

    public Color(@NotBlank(message = "Le rgv ne peut pas être vide !") String codergv, @NotBlank(message = "Le libelle ne peut pas être blanc !") String libelle) {
        this.codergv = codergv;
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodergv() {
        return codergv;
    }

    public void setCodergv(String codergv) {
        this.codergv = codergv;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
