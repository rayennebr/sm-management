package com.rayennebr.smmanagement.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="facture")
public class Facture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID factureId;
    private Date factureDate;
    private Long factureNum;
    private double total;
    private UUID commandeId;
    @ManyToOne
    @JoinColumn(name = "commandeId",referencedColumnName = "commandeId",insertable = false,updatable = false)
    private Commande commande;

    public Facture() {
    }

    public Facture(UUID factureId, Date factureDate, Long factureNum, double total, UUID commandeId, Commande commande) {
        this.factureId = factureId;
        this.factureDate = factureDate;
        this.factureNum = factureNum;
        this.total = total;
        this.commandeId = commandeId;
        this.commande = commande;
    }

    public UUID getFactureId() {
        return factureId;
    }

    public void setFactureId(UUID factureId) {
        this.factureId = factureId;
    }

    public Date getFactureDate() {
        return factureDate;
    }

    public void setFactureDate(Date factureDate) {
        this.factureDate = factureDate;
    }

    public Long getFactureNum() {
        return factureNum;
    }

    public void setFactureNum(Long factureNum) {
        this.factureNum = factureNum;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public UUID getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(UUID commandeId) {
        this.commandeId = commandeId;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facture facture = (Facture) o;
        return Double.compare(facture.total, total) == 0 && Objects.equals(factureId, facture.factureId) && Objects.equals(factureDate, facture.factureDate) && Objects.equals(factureNum, facture.factureNum) && Objects.equals(commandeId, facture.commandeId) && Objects.equals(commande, facture.commande);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factureId, factureDate, factureNum, total, commandeId, commande);
    }

    @Override
    public String toString() {
        return "Facture{" +
                "factureId=" + factureId +
                ", factureDate=" + factureDate +
                ", factureNum=" + factureNum +
                ", total=" + total +
                ", commandeId=" + commandeId +
                ", commande=" + commande +
                '}';
    }
}
