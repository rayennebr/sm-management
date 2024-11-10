package com.rayennebr.smmanagement.entities;

import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "categorie")
@Builder
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID catId;
    private String catDes;

    public Categorie() {
    }

    public Categorie(UUID catId, String catDes) {
        this.catId = catId;
        this.catDes = catDes;
    }

    public UUID getCatId() {
        return catId;
    }

    public void setCatId(UUID catId) {
        this.catId = catId;
    }

    public String getCatDes() {
        return catDes;
    }

    public void setCatDes(String catDes) {
        this.catDes = catDes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return Objects.equals(catId, categorie.catId) && Objects.equals(catDes, categorie.catDes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catId, catDes);
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "catId=" + catId +
                ", catDes='" + catDes + '\'' +
                '}';
    }
}
