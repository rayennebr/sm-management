package com.rayennebr.smmanagement.controllers;

import com.rayennebr.smmanagement.dtos.Response;
import com.rayennebr.smmanagement.entities.Tva;
import com.rayennebr.smmanagement.services.ITvaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tva")
@CrossOrigin("*")
public class TvaController {
    
    private final ITvaService tvaService;

    public TvaController(ITvaService tvaService) {
        this.tvaService = tvaService;
    }


    @GetMapping("/")
    Response<List<Tva>> getAllTva()
    {
        try{
            return Response.<List<Tva>>builder()
                    .status(HttpStatus.OK)
                    .data(tvaService.getAllTva())
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<List<Tva>>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/")
    Response<Tva> addTva(@RequestBody Tva tva)
    {
        try{
            return Response.<Tva>builder()
                    .status(HttpStatus.OK)
                    .data(tvaService.saveTva(tva))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Tva>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PutMapping("/{tvaId}")
    Response<Tva>updateTva(@PathVariable UUID tvaId, @RequestBody Tva tva)
    {
        try{
            return Response.<Tva>builder()
                    .status(HttpStatus.OK)
                    .data(tvaService.updateTva(tvaId,tva))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Tva>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @DeleteMapping("/{tvaId}")
    Response<Tva>deleteTva(@PathVariable UUID tvaId)
    {
        try{
            return Response.<Tva>builder()
                    .status(HttpStatus.OK)
                    .data(tvaService.deleteTva(tvaId))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Tva>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }
}
