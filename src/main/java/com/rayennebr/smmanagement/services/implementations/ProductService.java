package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.Product;
import com.rayennebr.smmanagement.mappers.IProductMapper;
import com.rayennebr.smmanagement.repositories.ProductRepository;
import com.rayennebr.smmanagement.services.IProductService;
import com.rayennebr.smmanagement.services.IStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
@Slf4j
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final IProductMapper productMapper;
    private final IStockService stockService;

    public ProductService(ProductRepository productRepository,
                          IProductMapper productMapper,
                          IStockService stockService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.stockService = stockService;
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


    @Override
    @Scheduled(cron = "0 0 * * * *") // Runs every hour
    public List<Product> verifyProductStock() {
        //todo: verify all the product stock and return the filtred list
        return productRepository.findAll()
                .stream()
                .filter(product -> {
                    try {
                        return stockService.getStockQte(product.getStockId()) == product.getProdQteAlerte();
                    } catch (Exception e) {
                        log.error("Error fetching stock quantity for product ID: {}", product.getProdId(), e);
                        return false;
                    }
                })
                .toList();
    }
}
