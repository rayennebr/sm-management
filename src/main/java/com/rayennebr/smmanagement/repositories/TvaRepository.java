package com.rayennebr.smmanagement.repositories;

import com.rayennebr.smmanagement.entities.Tva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TvaRepository extends JpaRepository<Tva, UUID> {
}
