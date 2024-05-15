package com.rayennebr.smmanagement.controllers;

import com.rayennebr.smmanagement.dtos.Response;
import com.rayennebr.smmanagement.entities.Categorie;
import com.rayennebr.smmanagement.services.ICategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categorie")
@CrossOrigin("*")
public class CategorieController {
    
    private final ICategorieService categorieService;

    public CategorieController(ICategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/")
    Response<List<Categorie>> getAllCategorie()
    {
        try{
            return Response.<List<Categorie>>builder()
                    .status(HttpStatus.OK)
                    .data(categorieService.getAllCategorie())
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<List<Categorie>>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/")
    Response<Categorie> addCategorie(@RequestBody Categorie categorie)
    {
        try{
            return Response.<Categorie>builder()
                    .status(HttpStatus.OK)
                    .data(categorieService.saveCategorie(categorie))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Categorie>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PutMapping("/{catId}")
    Response<Categorie>updateCategorie(@PathVariable UUID catId, @RequestBody Categorie categorie)
    {
        try{
            return Response.<Categorie>builder()
                    .status(HttpStatus.OK)
                    .data(categorieService.updateCategorie(catId,categorie))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Categorie>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @DeleteMapping("/{catId}")
    Response<Categorie>deleteCategorie(@PathVariable UUID catId)
    {
        try{
            return Response.<Categorie>builder()
                    .status(HttpStatus.OK)
                    .data(categorieService.deleteCategorie(catId))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Categorie>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }
}
