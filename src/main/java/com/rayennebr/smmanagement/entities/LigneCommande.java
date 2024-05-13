package com.rayennebr.smmanagement.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ligneCommande")
public class LigneCommande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  UUID ligComId;
    private int ligComQte;
    private int ligComTotal;
    private UUID prodId;
    private UUID commandeId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "prodId",name = "prodId",insertable = false,updatable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "commandeId",referencedColumnName = "commandeId",insertable = false,updatable = false)
    private Commande commande;

    public LigneCommande() {
    }

    public LigneCommande(UUID ligComId, int ligComQte, int ligComTotal, UUID prodId, UUID commandeId, Product product, Commande commande) {
        this.ligComId = ligComId;
        this.ligComQte = ligComQte;
        this.ligComTotal = ligComTotal;
        this.prodId = prodId;
        this.commandeId = commandeId;
        this.product = product;
        this.commande = commande;
    }

    public UUID getLigComId() {
        return ligComId;
    }

    public void setLigComId(UUID ligComId) {
        this.ligComId = ligComId;
    }

    public int getLigComQte() {
        return ligComQte;
    }

    public void setLigComQte(int ligComQte) {
        this.ligComQte = ligComQte;
    }

    public int getLigComTotal() {
        return ligComTotal;
    }

    public void setLigComTotal(int ligComTotal) {
        this.ligComTotal = ligComTotal;
    }

    public UUID getProdId() {
        return prodId;
    }

    public void setProdId(UUID prodId) {
        this.prodId = prodId;
    }

    public UUID getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(UUID commandeId) {
        this.commandeId = commandeId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        LigneCommande that = (LigneCommande) o;
        return ligComQte == that.ligComQte && ligComTotal == that.ligComTotal && Objects.equals(ligComId, that.ligComId) && Objects.equals(prodId, that.prodId) && Objects.equals(commandeId, that.commandeId) && Objects.equals(product, that.product) && Objects.equals(commande, that.commande);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ligComId, ligComQte, ligComTotal, prodId, commandeId, product, commande);
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "ligComId=" + ligComId +
                ", ligComQte=" + ligComQte +
                ", ligComTotal=" + ligComTotal +
                ", prodId=" + prodId +
                ", commandeId=" + commandeId +
                ", product=" + product +
                ", commande=" + commande +
                '}';
    }
}
