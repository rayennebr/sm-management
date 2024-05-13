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
    private UUID prodId;
    private String tvaDes;
    private double tvaTaux;
    @ManyToOne
    @JoinColumn(referencedColumnName = "prodId",columnDefinition = "prodId",insertable = false,updatable = false)
    private Product product;

    public Tva() {
    }

    public Tva(UUID tvaUid, UUID prodId, String tvaDes, double tvaTaux, Product product) {
        this.tvaUid = tvaUid;
        this.prodId = prodId;
        this.tvaDes = tvaDes;
        this.tvaTaux = tvaTaux;
        this.product = product;
    }

    public UUID getTvaUid() {
        return tvaUid;
    }

    public void setTvaUid(UUID tvaUid) {
        this.tvaUid = tvaUid;
    }

    public UUID getProdId() {
        return prodId;
    }

    public void setProdId(UUID prodId) {
        this.prodId = prodId;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tva tva = (Tva) o;
        return Double.compare(tva.tvaTaux, tvaTaux) == 0 && Objects.equals(tvaUid, tva.tvaUid) && Objects.equals(prodId, tva.prodId) && Objects.equals(tvaDes, tva.tvaDes) && Objects.equals(product, tva.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tvaUid, prodId, tvaDes, tvaTaux, product);
    }

    @Override
    public String toString() {
        return "Tva{" +
                "tvaUid=" + tvaUid +
                ", prodId=" + prodId +
                ", tvaDes='" + tvaDes + '\'' +
                ", tvaTaux=" + tvaTaux +
                ", product=" + product +
                '}';
    }
}
