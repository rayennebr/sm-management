package com.rayennebr.smmanagement.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "stock")
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID stockId;
    private Date stockDate;
    private int stockQte;

    public Stock() {
    }

    public Stock(UUID stockId, Date stockDate, int stockQte) {
        this.stockId = stockId;
        this.stockDate = stockDate;
        this.stockQte = stockQte;
    }

    public UUID getStockId() {
        return stockId;
    }

    public void setStockId(UUID stockId) {
        this.stockId = stockId;
    }

    public Date getStockDate() {
        return stockDate;
    }

    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
    }

    public int getStockQte() {
        return stockQte;
    }

    public void setStockQte(int stockQte) {
        this.stockQte = stockQte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return stockQte == stock.stockQte && Objects.equals(stockId, stock.stockId) && Objects.equals(stockDate, stock.stockDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId, stockDate, stockQte);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", stockDate=" + stockDate +
                ", stockQte=" + stockQte +
                '}';
    }
}
