package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.Commande;
import com.rayennebr.smmanagement.mappers.ICommandeMapper;
import com.rayennebr.smmanagement.repositories.CommandeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommandeServiceTest {

    @Mock
    private  CommandeRepository commandeRepository;
    @Mock
    private  ICommandeMapper commandeMapper;

    @InjectMocks
    private CommandeService commandeService;

    private AutoCloseable closeable;

    private Commande commande=new Commande();
    @BeforeEach
    void setUp() {
        closeable= MockitoAnnotations.openMocks(this);
         commande= Commande.builder()
                .commandeId(UUID.randomUUID())
                .status(false)
                .comDate(new Date())
                .comNum(1L)
                .build();

    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("shoud save commande")
    void should_save_commande()
    {
        //given
        var savedCommande=commande;
        //when
        when(commandeRepository.save(commande)).thenReturn(savedCommande);
        var res=commandeService.saveCommande(commande);
        //then
        assertEquals(res,commande);
        verify(commandeRepository,times(1)).save(commande);

    }

    @Test
    @DisplayName("should find by id")
    void should_find_by_Id(){

        //given
        var commandSearched=commande;

        //when
        when(commandeRepository.findById(commandSearched.getCommandeId())).thenReturn(Optional.of(commandSearched));
        var result=commandeService.findCommandeById(commandSearched.getCommandeId());

        //then
        verify(commandeRepository,times(1)).findById(commandSearched.getCommandeId());
        assertEquals(commandSearched,result);
    }
}