package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.LigneCommande;
import com.rayennebr.smmanagement.errorHandlers.GenericException;
import com.rayennebr.smmanagement.mappers.ILigneCommandeMapper;
import com.rayennebr.smmanagement.repositories.LigneCommandeRepository;
import com.rayennebr.smmanagement.services.ICommandeService;
import com.rayennebr.smmanagement.services.ILigneCommandeService;
import com.rayennebr.smmanagement.services.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
@Slf4j
public class LigneCommandeService implements ILigneCommandeService {

    private final LigneCommandeRepository ligneCommandeRepository;
    private final ILigneCommandeMapper ligneCommandeMapper;
    private final IProductService productService;
    private final ICommandeService commandeService;

    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository, ILigneCommandeMapper ligneCommandeMapper, IProductService productService, ICommandeService commandeService) {
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.ligneCommandeMapper = ligneCommandeMapper;
        this.productService = productService;
        this.commandeService = commandeService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public LigneCommande saveLigneCommande(LigneCommande ligneCommande) throws GenericException {
        try {
            /**
             * verify disponibility of the product in the stock
             */
            var product = productService.getProductById(ligneCommande.getProdId());
            if (product.getProdQte() < ligneCommande.getLigComQte()) {
                throw new GenericException("Quantité insuffisante pour le produit avec l'ID: " + product.getProdId());
            }
            /**
             * set the total of the commande
             */
            var commande=commandeService.findCommandeById(ligneCommande.getCommandeId());
            commande.setTotal(commande.getTotal()+ligneCommande.getLigComTotal());
            commandeService.updateCommande(commande.getCommandeId(),commande);
            /***********/
            return ligneCommandeRepository.save(ligneCommande);
         } catch (Exception e) {
            // Log and throw a generic exception
            log.error("Error when adding ligneCommande", e);
            throw new GenericException("Error when adding ligneCommande", e);
        }

    }

    @Override
    public LigneCommande updateLigneCommande(UUID ligCommId, LigneCommande commande) {
        var updatedLigneCommande=ligneCommandeRepository.findById(ligCommId)
                .orElseThrow(()->new NoSuchElementException("ligne commande n'existe pas"));
        ligneCommandeMapper.mapToUpdate(commande,updatedLigneCommande);
        ligneCommandeRepository.saveAndFlush(updatedLigneCommande);
        return updatedLigneCommande;
    }

    @Override
    public LigneCommande deleteLigneCommande(UUID ligComId) {
        var deletedLigneCommande=ligneCommandeRepository.findById(ligComId)
                .orElseThrow(()->new NoSuchElementException("ligne commande n'existe pas"));
        ligneCommandeRepository.delete(deletedLigneCommande);
        return deletedLigneCommande;
    }

    @Override
    public List<LigneCommande> retrieveAllLigneCommande() {
        return ligneCommandeRepository.findAll();
    }

    @Override
    public List<LigneCommande> findAllByCommandeId(UUID commandeUID) {
        return ligneCommandeRepository.findAllByCommandeId(commandeUID);
    }

    @Override
    public List<LigneCommande> findAllByProdId(UUID prodUID) {
        return ligneCommandeRepository.findAllByProdId(prodUID);
    }
}
