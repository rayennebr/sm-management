package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.Product;
import com.rayennebr.smmanagement.mappers.IProductMapper;
import com.rayennebr.smmanagement.repositories.ProductRepository;
import com.rayennebr.smmanagement.services.IProductService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final IProductMapper productMapper;

    public ProductService(ProductRepository productRepository, IProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(UUID prodId, Product product) {
        var updatedProduct=productRepository.findById(prodId)
                .orElseThrow(()->new NoSuchElementException("produit n'existe pas !"));
        productMapper.mapForUpdate(product,updatedProduct);
        productRepository.saveAndFlush(updatedProduct);
        return updatedProduct;
    }

    @Override
    public Product deleteProduct(UUID prodId) {
        var deletedProduct=productRepository.findById(prodId)
                .orElseThrow(()->new NoSuchElementException("produit n'existe pas !"));
        productRepository.delete(deletedProduct);
        return deletedProduct;
    }

    @Override
    public Product getProductById(UUID prdId) {
        return productRepository.findById(prdId)
                .orElseThrow(()->new NoSuchElementException("produit n'existe pas !"));
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
