package com.rayennebr.smmanagement.services;

import com.rayennebr.smmanagement.entities.LigneCommande;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ILigneCommandeService {

    LigneCommande saveLigneCommande(LigneCommande ligneCommande);
    LigneCommande updateLigneCommande(UUID ligCommId,LigneCommande commande);
    LigneCommande deleteLigneCommande(UUID ligComId);
    List<LigneCommande> retrieveAllLigneCommande();
}
