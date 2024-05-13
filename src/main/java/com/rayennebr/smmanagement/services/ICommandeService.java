package com.rayennebr.smmanagement.services;

import com.rayennebr.smmanagement.entities.Commande;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ICommandeService {

    Commande saveCommande(Commande commande);
    Commande updateCommande(UUID commId,Commande commande);
    Commande deleteCommande(UUID commId);
    List<Commande>retrieveCommande();
}
