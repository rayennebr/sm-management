package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.Commande;
import com.rayennebr.smmanagement.mappers.ICommandeMapper;
import com.rayennebr.smmanagement.repositories.CommandeRepository;
import com.rayennebr.smmanagement.services.ICommandeService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
public class CommandeService implements ICommandeService {

    private final CommandeRepository commandeRepository;
    private final ICommandeMapper commandeMapper;

    public CommandeService(CommandeRepository commandeRepository, ICommandeMapper commandeMapper) {
        this.commandeRepository = commandeRepository;
        this.commandeMapper = commandeMapper;
    }

    @Override
    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(UUID commId, Commande commande) {
       var updatedCommande=commandeRepository.findById(commId)
               .orElseThrow(()->new NoSuchElementException("commande n'existe pas !"));
       commandeMapper.matoUpdate(commande,updatedCommande);
       commandeRepository.saveAndFlush(updatedCommande);
        return updatedCommande;
    }

    @Override
    public Commande deleteCommande(UUID commId) {
        var deletedCommande=commandeRepository.findById(commId)
                .orElseThrow(()->new NoSuchElementException("commande n'existe pas !"));
        commandeRepository.delete(deletedCommande);
        return deletedCommande;
    }

    @Override
    public List<Commande> retrieveCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande findCommandeById(UUID commId) {
        return commandeRepository.findById(commId)
                .orElseThrow(()->new NoSuchElementException("commande n'existe pas !"));
    }
}
