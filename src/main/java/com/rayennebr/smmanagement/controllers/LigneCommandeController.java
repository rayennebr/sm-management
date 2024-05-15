package com.rayennebr.smmanagement.controllers;

import com.rayennebr.smmanagement.dtos.Response;
import com.rayennebr.smmanagement.entities.LigneCommande;
import com.rayennebr.smmanagement.services.ILigneCommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/lignecommandes")
@CrossOrigin("*")
public class LigneCommandeController {
    
    private final ILigneCommandeService commandeService;

    public LigneCommandeController(ILigneCommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/")
    Response<List<LigneCommande>> getAllLigneCommande()
    {
        try{
            return Response.<List<LigneCommande>>builder()
                    .status(HttpStatus.OK)
                    .data(commandeService.retrieveAllLigneCommande())
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<List<LigneCommande>>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/")
    Response<LigneCommande> addLigneCommande(@RequestBody LigneCommande ligneCommande)
    {
        try{
            return Response.<LigneCommande>builder()
                    .status(HttpStatus.OK)
                    .data(commandeService.saveLigneCommande(ligneCommande))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<LigneCommande>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PutMapping("/{LigneComId}")
    Response<LigneCommande>updateLigneCommande(@PathVariable UUID LigneComId, @RequestBody LigneCommande ligneCommande)
    {
        try{
            return Response.<LigneCommande>builder()
                    .status(HttpStatus.OK)
                    .data(commandeService.updateLigneCommande(LigneComId,ligneCommande))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<LigneCommande>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @DeleteMapping("/{LigneComId}")
    Response<LigneCommande>deleteLigneCommande(@PathVariable UUID LigneComId)
    {
        try{
            return Response.<LigneCommande>builder()
                    .status(HttpStatus.OK)
                    .data(commandeService.deleteLigneCommande(LigneComId))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<LigneCommande>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }
    
}
