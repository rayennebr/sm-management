package com.rayennebr.smmanagement.entities;

import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "commande")
@Builder
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID commandeId;
    private Long comNum;
    private Date comDate;
    private double total;
    private boolean status;

    public Commande() {
    }

    public Commande(UUID commandeId, Long comNum, Date comDate, double total, boolean status) {
        this.commandeId = commandeId;
        this.comNum = comNum;
        this.comDate = comDate;
        this.total = total;
        this.status = status;
    }

    public UUID getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(UUID commandeId) {
        this.commandeId = commandeId;
    }

    public Long getComNum() {
        return comNum;
    }

    public void setComNum(Long comNum) {
        this.comNum = comNum;
    }

    public Date getComDate() {
        return comDate;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return Double.compare(commande.total, total) == 0 && status == commande.status && Objects.equals(commandeId, commande.commandeId) && Objects.equals(comNum, commande.comNum) && Objects.equals(comDate, commande.comDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandeId, comNum, comDate, total, status);
    }

    @Override
    public String toString() {
        return "Commande{" +
                "commandeId=" + commandeId +
                ", comNum=" + comNum +
                ", comDate=" + comDate +
                ", total=" + total +
                ", status=" + status +
                '}';
    }
}
