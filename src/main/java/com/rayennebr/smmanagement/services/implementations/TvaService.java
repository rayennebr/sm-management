package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.Tva;
import com.rayennebr.smmanagement.mappers.ITvaMapper;
import com.rayennebr.smmanagement.repositories.TvaRepository;
import com.rayennebr.smmanagement.services.ITvaService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
public class TvaService implements ITvaService {

    private final TvaRepository tvaRepository;
    private final ITvaMapper tvaMapper;

    public TvaService(TvaRepository tvaRepository, ITvaMapper tvaMapper) {
        this.tvaRepository = tvaRepository;
        this.tvaMapper = tvaMapper;
    }

    @Override
    public Tva saveTva(Tva tva) {
        return tvaRepository.save(tva);
    }

    @Override
    public Tva updateTva(UUID tvaId, Tva tva) {
        var updatedTva=tvaRepository.findById(tvaId)
                .orElseThrow(()->new NoSuchElementException("tva n'existe pas"));
        tvaMapper.mapToUpdate(tva,updatedTva);
        tvaRepository.saveAndFlush(tva);
        return updatedTva;
    }

    @Override
    public Tva deleteTva(UUID tvaId) {
        var deletedTva=tvaRepository.findById(tvaId)
                .orElseThrow(()->new NoSuchElementException("tva n'existe pas"));
        tvaRepository.delete(deletedTva);
        return deletedTva;
    }

    @Override
    public List<Tva> getAllTva() {
        return tvaRepository.findAll();
    }
}
