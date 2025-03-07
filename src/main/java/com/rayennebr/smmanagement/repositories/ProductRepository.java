package com.rayennebr.smmanagement.repositories;

import com.rayennebr.smmanagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product>findAllByCatId(UUID catUID);
}
