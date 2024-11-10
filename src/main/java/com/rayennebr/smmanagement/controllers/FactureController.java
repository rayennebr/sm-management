package com.rayennebr.smmanagement.controllers;

import com.rayennebr.smmanagement.dtos.Response;
import com.rayennebr.smmanagement.entities.Facture;
import com.rayennebr.smmanagement.services.IFactureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/factures")
@CrossOrigin("*")
public class FactureController {
    
    private final IFactureService factureService;

    public FactureController(IFactureService factureService) {
        this.factureService = factureService;
    }

    @GetMapping("/")
    Response<List<Facture>> getAllFacture()
    {
        try{
            return Response.<List<Facture>>builder()
                    .status(HttpStatus.OK)
                    .data(factureService.retrieveAllFacture())
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<List<Facture>>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/")
    Response<Facture> addFacture(@RequestBody Facture facture)
    {
        try{
            return Response.<Facture>builder()
                    .status(HttpStatus.OK)
                    .data(factureService.addFacture(facture))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Facture>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/validateFacture/{factId}")
    Response<Facture>validateFacture(@PathVariable UUID factId)
    {
         try{
            return Response.<Facture>builder()
                    .status(HttpStatus.OK)
                    .data(factureService.validerFacture(factId))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Facture>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PutMapping("/{factId}")
    Response<Facture>updateFacture(@PathVariable UUID factId, @RequestBody Facture facture)
    {
        try{
            return Response.<Facture>builder()
                    .status(HttpStatus.OK)
                    .data(factureService.updateFacture(factId,facture))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Facture>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @DeleteMapping("/{factId}")
    Response<Facture>deleteFacture(@PathVariable UUID factId)
    {
        try{
            return Response.<Facture>builder()
                    .status(HttpStatus.OK)
                    .data(factureService.deleteFacture(factId))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Facture>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @GetMapping("/byCommandId/{commandUID}")
    Response<List<Facture>> getAllByCommandeId(@PathVariable UUID commandUID)
    {
        try{
            return Response.<List<Facture>>builder()
                    .status(HttpStatus.OK)
                    .data(factureService.getAllByCommandeId(commandUID))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<List<Facture>>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

}
