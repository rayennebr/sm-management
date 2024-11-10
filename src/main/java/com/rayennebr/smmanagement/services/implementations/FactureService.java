package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.Facture;
import com.rayennebr.smmanagement.errorHandlers.GenericException;
import com.rayennebr.smmanagement.mappers.IFactureMapper;
import com.rayennebr.smmanagement.repositories.FactureRepository;
import com.rayennebr.smmanagement.services.ICommandeService;
import com.rayennebr.smmanagement.services.IFactureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
@Slf4j
public class FactureService implements IFactureService {

    private final FactureRepository factureRepository;
    private final IFactureMapper factureMapper;
    private final ICommandeService commandeService;

    public FactureService(FactureRepository factureRepository, IFactureMapper factureMapper, ICommandeService commandeService) {
        this.factureRepository = factureRepository;
        this.factureMapper = factureMapper;
        this.commandeService = commandeService;
    }

    @Override
    public Facture addFacture(Facture facture) {
        facture.setFactureDate(new Date());
        return factureRepository.save(facture);
    }

    @Override
    public Facture deleteFacture(UUID factId) {
        var deletedFacture=factureRepository.findById(factId)
                .orElseThrow(()->new NoSuchElementException("facture n'existe pas"));
        factureRepository.delete(deletedFacture);
        return deletedFacture;
    }

    @Override
    public Facture updateFacture(UUID factId, Facture facture) {
        var updatedFacture=factureRepository.findById(factId)
                .orElseThrow(()->new NoSuchElementException("facture n'existe pas"));
        factureMapper.mapToUpdate(facture,updatedFacture);
        factureRepository.saveAndFlush(updatedFacture);
        return updatedFacture;
    }

    @Override
    public List<Facture> retrieveAllFacture() {
        return factureRepository.findAll();
    }

    @Override
    public Facture validerFacture(UUID factId) throws GenericException{
      try{
          var facture=factureRepository.findById(factId)
                  .orElseThrow(()->new NoSuchElementException("facture n'existe pas"));
          var commande=commandeService.findCommandeById(facture.getCommandeId());
          facture.setFactureTotal(commande.getTotal());
          if(facture.getFactureRemise()!=0)
          {
              facture.setFactureTotal((facture.getFactureRemise())* facture.getFactureRemise());
          }
          return updateFacture(factId,facture);
      } catch (Exception e) {
        // Log and throw a generic exception
        log.error("Error when validating facture", e);
        throw new GenericException("Error when  validating facture", e);
    }
    }

    @Override
    public List<Facture> getAllByCommandeId(UUID commandUID) {
        return factureRepository.findAllByCommandeId(commandUID);
    }
}
