package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.Stock;
import com.rayennebr.smmanagement.mappers.IStockMapper;
import com.rayennebr.smmanagement.repositories.StockRepository;
import com.rayennebr.smmanagement.services.IStockService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
public class StockService implements IStockService {

    private final StockRepository stockRepository;
    private final IStockMapper stockMapper;

    public StockService(StockRepository stockRepository, IStockMapper stockMapper) {
        this.stockRepository = stockRepository;
        this.stockMapper = stockMapper;
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(UUID stockId, Stock stock) {
        var updatedStock=stockRepository.findById(stockId)
                .orElseThrow(()->new NoSuchElementException("stock n'existe pas"));
        stockMapper.mapToUpdate(stock,updatedStock);
        stockRepository.saveAndFlush(updatedStock);
        return updatedStock;
    }

    @Override
    public Stock deleteStock(UUID stockId) {
        var deletedStock=stockRepository.findById(stockId)
                .orElseThrow(()->new NoSuchElementException("stock n'existe pas !"));
        stockRepository.delete(deletedStock);
        return deletedStock;
    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }
}
