package com.rayennebr.smmanagement.services;

import com.rayennebr.smmanagement.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IProductService {

    Product saveProduct(Product product);
    Product updateProduct(UUID prodId,Product product);
    Product deleteProduct(UUID prodId);
    Product getProductById(UUID prdId);
    List<Product>getAllProduct();
    List<Product>verifyProductStock();
    List<Product>findAllByCatId(UUID catUID);
}
