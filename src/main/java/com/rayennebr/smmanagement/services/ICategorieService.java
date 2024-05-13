package com.rayennebr.smmanagement.services;

import com.rayennebr.smmanagement.entities.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ICategorieService {
    Categorie saveCategorie(Categorie Categorie);
    Categorie updateCategorie(UUID catId, Categorie Categorie);
    Categorie deleteCategorie(UUID catId);
    List<Categorie> getAllCategorie();
}
