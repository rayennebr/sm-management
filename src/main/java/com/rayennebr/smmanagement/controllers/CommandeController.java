package com.rayennebr.smmanagement.controllers;

import com.rayennebr.smmanagement.dtos.Response;
import com.rayennebr.smmanagement.entities.Commande;
import com.rayennebr.smmanagement.services.ICommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/commande")
@CrossOrigin("*")
public class CommandeController {

    private final ICommandeService commandeService;

    public CommandeController(ICommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/")
    Response<List<Commande>> getAllCommande()
    {
        try{
            return Response.<List<Commande>>builder()
                    .status(HttpStatus.OK)
                    .data(commandeService.retrieveCommande())
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<List<Commande>>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/")
    Response<Commande> addCommande(@RequestBody Commande commande)
    {
        try{
            return Response.<Commande>builder()
                    .status(HttpStatus.OK)
                    .data(commandeService.saveCommande(commande))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Commande>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PutMapping("/{comId}")
    Response<Commande>updateCommande(@PathVariable UUID comId, @RequestBody Commande commande)
    {
        try{
            return Response.<Commande>builder()
                    .status(HttpStatus.OK)
                    .data(commandeService.updateCommande(comId,commande))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Commande>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @DeleteMapping("/{comId}")
    Response<Commande>deleteCommande(@PathVariable UUID comId)
    {
        try{
            return Response.<Commande>builder()
                    .status(HttpStatus.OK)
                    .data(commandeService.deleteCommande(comId))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Commande>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }
}
