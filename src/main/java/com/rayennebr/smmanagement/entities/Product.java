package com.rayennebr.smmanagement.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID prodId;
    private String prodDes;
    private int prodPrix;
    private int prodQte;
    private int prodQteAlerte;
    private String reference;
    private UUID catId;
    private UUID stockId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "catId",columnDefinition = "catId",insertable = false,updatable = false)
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(referencedColumnName = "stockId",columnDefinition = "stockId",insertable = false,updatable = false)
    private Stock stock;

    public Product() {
    }

    public Product(UUID prodId, String prodDes, int prodPrix, int prodQte, int prodQteAlerte, String reference, UUID catId, UUID stockId, Categorie categorie, Stock stock) {
        this.prodId = prodId;
        this.prodDes = prodDes;
        this.prodPrix = prodPrix;
        this.prodQte = prodQte;
        this.prodQteAlerte = prodQteAlerte;
        this.reference = reference;
        this.catId = catId;
        this.stockId = stockId;
        this.categorie = categorie;
        this.stock = stock;
    }

    public UUID getProdId() {
        return prodId;
    }

    public void setProdId(UUID prodId) {
        this.prodId = prodId;
    }

    public String getProdDes() {
        return prodDes;
    }

    public void setProdDes(String prodDes) {
        this.prodDes = prodDes;
    }

    public int getProdPrix() {
        return prodPrix;
    }

    public void setProdPrix(int prodPrix) {
        this.prodPrix = prodPrix;
    }

    public int getProdQte() {
        return prodQte;
    }

    public void setProdQte(int prodQte) {
        this.prodQte = prodQte;
    }

    public int getProdQteAlerte() {
        return prodQteAlerte;
    }

    public void setProdQteAlerte(int prodQteAlerte) {
        this.prodQteAlerte = prodQteAlerte;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public UUID getCatId() {
        return catId;
    }

    public void setCatId(UUID catId) {
        this.catId = catId;
    }

    public UUID getStockId() {
        return stockId;
    }

    public void setStockId(UUID stockId) {
        this.stockId = stockId;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return prodPrix == product.prodPrix && prodQte == product.prodQte && prodQteAlerte == product.prodQteAlerte && Objects.equals(prodId, product.prodId) && Objects.equals(prodDes, product.prodDes) && Objects.equals(reference, product.reference) && Objects.equals(catId, product.catId) && Objects.equals(stockId, product.stockId) && Objects.equals(categorie, product.categorie) && Objects.equals(stock, product.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, prodDes, prodPrix, prodQte, prodQteAlerte, reference, catId, stockId, categorie, stock);
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodDes='" + prodDes + '\'' +
                ", prodPrix=" + prodPrix +
                ", prodQte=" + prodQte +
                ", prodQteAlerte=" + prodQteAlerte +
                ", reference='" + reference + '\'' +
                ", catId=" + catId +
                ", stockId=" + stockId +
                ", categorie=" + categorie +
                ", stock=" + stock +
                '}';
    }
}
