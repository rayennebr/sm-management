package com.rayennebr.smmanagement.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tva")
public class Tva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tvaUid;
    private UUID factureId;
    private String tvaDes;
    private double tvaTaux;
    @ManyToOne
    @JoinColumn(referencedColumnName = "factureId",columnDefinition = "factureId",insertable = false,updatable = false)
    private Facture facture;

    public Tva() {
    }

    public Tva(UUID tvaUid, UUID factureId, String tvaDes, double tvaTaux, Facture facture) {
        this.tvaUid = tvaUid;
        this.factureId = factureId;
        this.tvaDes = tvaDes;
        this.tvaTaux = tvaTaux;
        this.facture = facture;
    }

    public UUID getTvaUid() {
        return tvaUid;
    }

    public void setTvaUid(UUID tvaUid) {
        this.tvaUid = tvaUid;
    }

    public UUID getFactureId() {
        return factureId;
    }

    public void setFactureId(UUID factureId) {
        this.factureId = factureId;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public String getTvaDes() {
        return tvaDes;
    }

    public void setTvaDes(String tvaDes) {
        this.tvaDes = tvaDes;
    }

    public double getTvaTaux() {
        return tvaTaux;
    }

    public void setTvaTaux(double tvaTaux) {
        this.tvaTaux = tvaTaux;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tva tva = (Tva) o;
        return Double.compare(tva.tvaTaux, tvaTaux) == 0 && Objects.equals(tvaUid, tva.tvaUid) && Objects.equals(factureId, tva.factureId) && Objects.equals(tvaDes, tva.tvaDes) && Objects.equals(facture, tva.facture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tvaUid, factureId, tvaDes, tvaTaux, facture);
    }

    @Override
    public String toString() {
        return "Tva{" +
                "tvaUid=" + tvaUid +
                ", factureId=" + factureId +
                ", tvaDes='" + tvaDes + '\'' +
                ", tvaTaux=" + tvaTaux +
                ", facture=" + facture +
                '}';
    }
}
