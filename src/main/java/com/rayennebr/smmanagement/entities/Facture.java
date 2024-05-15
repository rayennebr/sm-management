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
    private double factureTotal;
    private UUID commandeId;
    private String factureType;
    private double factureRemise;
    private String status;
    @ManyToOne
    @JoinColumn(name = "commandeId",referencedColumnName = "commandeId",insertable = false,updatable = false)
    private Commande commande;

    public Facture() {
    }

    public Facture(UUID factureId, Date factureDate, double factureTotal, UUID commandeId, String factureType, double factureRemise, String status, Commande commande) {
        this.factureId = factureId;
        this.factureDate = factureDate;
        this.factureTotal = factureTotal;
        this.commandeId = commandeId;
        this.factureType = factureType;
        this.factureRemise = factureRemise;
        this.status = status;
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

    public double getFactureTotal() {
        return factureTotal;
    }

    public void setFactureTotal(double factureTotal) {
        this.factureTotal = factureTotal;
    }

    public String getFactureType() {
        return factureType;
    }

    public void setFactureType(String factureType) {
        this.factureType = factureType;
    }

    public double getFactureRemise() {
        return factureRemise;
    }

    public void setFactureRemise(double factureRemise) {
        this.factureRemise = factureRemise;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facture facture = (Facture) o;
        return Double.compare(facture.factureTotal, factureTotal) == 0 && Double.compare(facture.factureRemise, factureRemise) == 0 && Objects.equals(factureId, facture.factureId) && Objects.equals(factureDate, facture.factureDate) && Objects.equals(commandeId, facture.commandeId) && Objects.equals(factureType, facture.factureType) && Objects.equals(status, facture.status) && Objects.equals(commande, facture.commande);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factureId, factureDate, factureTotal, commandeId, factureType, factureRemise, status, commande);
    }

    @Override
    public String toString() {
        return "Facture{" +
                "factureId=" + factureId +
                ", factureDate=" + factureDate +
                ", factureTotal=" + factureTotal +
                ", commandeId=" + commandeId +
                ", factureType='" + factureType + '\'' +
                ", factureRemise=" + factureRemise +
                ", status='" + status + '\'' +
                ", commande=" + commande +
                '}';
    }
}
