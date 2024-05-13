package com.rayennebr.smmanagement.repositories;

import com.rayennebr.smmanagement.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, UUID> {
}
