package com.rayennebr.smmanagement.services;

import com.rayennebr.smmanagement.entities.Facture;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IFactureService {

    Facture addFacture(Facture facture);
    Facture deleteFacture(UUID factId);
    Facture updateFacture(UUID factId,Facture facture);
    List<Facture> retrieveAllFacture();
}
