package com.rayennebr.smmanagement.services;

import com.rayennebr.smmanagement.entities.LigneCommande;
import com.rayennebr.smmanagement.errorHandlers.GenericException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ILigneCommandeService {

    LigneCommande saveLigneCommande(LigneCommande ligneCommande) throws GenericException;
    LigneCommande updateLigneCommande(UUID ligCommId,LigneCommande commande);
    LigneCommande deleteLigneCommande(UUID ligComId);
    List<LigneCommande> retrieveAllLigneCommande();
}
