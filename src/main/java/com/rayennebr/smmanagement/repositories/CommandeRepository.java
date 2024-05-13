package com.rayennebr.smmanagement.repositories;

import com.rayennebr.smmanagement.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, UUID> {
}
