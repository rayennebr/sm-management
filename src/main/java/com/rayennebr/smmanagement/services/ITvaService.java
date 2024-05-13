package com.rayennebr.smmanagement.services;

import com.rayennebr.smmanagement.entities.Tva;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ITvaService {
    Tva saveTva(Tva Tva);
    Tva updateTva(UUID tvaId, Tva Tva);
    Tva deleteTva(UUID tvaId);
    List<Tva> getAllTva();
}
