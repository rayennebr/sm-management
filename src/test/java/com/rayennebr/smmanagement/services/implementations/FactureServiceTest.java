package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.Commande;
import com.rayennebr.smmanagement.entities.Facture;
import com.rayennebr.smmanagement.errorHandlers.GenericException;
import com.rayennebr.smmanagement.mappers.IFactureMapper;
import com.rayennebr.smmanagement.repositories.FactureRepository;
import com.rayennebr.smmanagement.services.ICommandeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FactureServiceTest {

    @Mock
    private FactureRepository factureRepository;

    @Mock
    private IFactureMapper factureMapper;

    @Mock
    private ICommandeService commandeService;

    private AutoCloseable closeable;

    @InjectMocks
    private FactureService factureService;

    @BeforeEach
    void setUp() {
        closeable=MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception
    {
        closeable.close();
    }

    @DisplayName("addFacture_ShouldSaveFacture")
    @Test
    void addFacture_ShouldSaveFacture() {
        Facture facture = new Facture();
        when(factureRepository.save(any(Facture.class))).thenReturn(facture);

        Facture savedFacture = factureService.addFacture(facture);

        assertNotNull(savedFacture);
        verify(factureRepository, times(1)).save(facture);
    }

    @Test
    void deleteFacture_ShouldDeleteAndReturnFacture() {
        UUID factId = UUID.randomUUID();
        Facture facture = new Facture();
        when(factureRepository.findById(factId)).thenReturn(Optional.of(facture));

        Facture deletedFacture = factureService.deleteFacture(factId);

        assertNotNull(deletedFacture);
        verify(factureRepository, times(1)).delete(facture);
    }

    @Test
    void deleteFacture_ShouldThrowException_WhenFactureNotFound() {
        UUID factId = UUID.randomUUID();
        when(factureRepository.findById(factId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> factureService.deleteFacture(factId));
    }

    @Test
    void updateFacture_ShouldUpdateAndReturnFacture() {
        UUID factId = UUID.randomUUID();
        Facture facture = new Facture();
        Facture updatedFacture = new Facture();
        when(factureRepository.findById(factId)).thenReturn(Optional.of(updatedFacture));

        Facture result = factureService.updateFacture(factId, facture);

        assertNotNull(result);
        verify(factureMapper, times(1)).mapToUpdate(facture, updatedFacture);
        verify(factureRepository, times(1)).saveAndFlush(updatedFacture);
    }

    @Test
    void retrieveAllFacture_ShouldReturnAllFactures() {
        List<Facture> factures = new ArrayList<>();
        when(factureRepository.findAll()).thenReturn(factures);

        List<Facture> result = factureService.retrieveAllFacture();

        assertEquals(factures, result);
        verify(factureRepository, times(1)).findAll();
    }

    @Test
    void validerFacture_ShouldUpdateFactureTotal() throws GenericException {
        UUID factId = UUID.randomUUID();
        Facture facture = new Facture();
        facture.setFactureRemise(0);
        when(factureRepository.findById(factId)).thenReturn(Optional.of(facture));
        var commande = mock(Commande.class); // Mocked object, replace with real type if necessary
        when(commandeService.findCommandeById(facture.getCommandeId())).thenReturn(commande);
        when(commande.getTotal()).thenReturn(100.0); // Assume getTotal returns 100.0

        Facture validatedFacture = factureService.validerFacture(factId);

        assertEquals(100.0, validatedFacture.getFactureTotal());
        verify(factureRepository, times(1)).saveAndFlush(validatedFacture);
    }

    @Test
    void validerFacture_ShouldThrowGenericException_OnError() {
        UUID factId = UUID.randomUUID();
        when(factureRepository.findById(factId)).thenThrow(new RuntimeException());

        assertThrows(GenericException.class, () -> factureService.validerFacture(factId));
    }

    @Test
    void getAllByCommandeId_ShouldReturnFacturesByCommandeId() {
        UUID commandUID = UUID.randomUUID();
        List<Facture> factures = new ArrayList<>();
        when(factureRepository.findAllByCommandeId(commandUID)).thenReturn(factures);

        List<Facture> result = factureService.getAllByCommandeId(commandUID);

        assertEquals(factures, result);
        verify(factureRepository, times(1)).findAllByCommandeId(commandUID);
    }
}
