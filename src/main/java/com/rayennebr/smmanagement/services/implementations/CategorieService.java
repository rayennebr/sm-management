package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.Categorie;
import com.rayennebr.smmanagement.mappers.ICategorieMapper;
import com.rayennebr.smmanagement.repositories.CategorieRepository;
import com.rayennebr.smmanagement.services.ICategorieService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
public class CategorieService implements ICategorieService {

        private final CategorieRepository categorieRepository;
        private final ICategorieMapper iCategorieMapper;

    public CategorieService(CategorieRepository categorieRepository, ICategorieMapper iCategorieMapper) {
        this.categorieRepository = categorieRepository;
        this.iCategorieMapper = iCategorieMapper;
    }

    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updateCategorie(UUID catId, Categorie categorie) {
        var updatedCategorie=categorieRepository.findById(catId)
                .orElseThrow(()->new NoSuchElementException("categorie n'existe pas !"));
        iCategorieMapper.mapToUpdate(categorie,updatedCategorie);
        categorieRepository.saveAndFlush(updatedCategorie);
        return updatedCategorie;
    }

    @Override
    public Categorie deleteCategorie(UUID catId) {
        var deletedCategorie=categorieRepository.findById(catId)
                .orElseThrow(()->new NoSuchElementException("catégorie n'existe pas !"));
        categorieRepository.delete(deletedCategorie);
        return deletedCategorie;
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }
}
