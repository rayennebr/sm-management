package com.rayennebr.smmanagement.services.implementations;

import com.rayennebr.smmanagement.entities.Stock;
import com.rayennebr.smmanagement.mappers.IStockMapper;
import com.rayennebr.smmanagement.repositories.StockRepository;
import com.rayennebr.smmanagement.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
public class StockService implements IStockService {

    @Autowired
    private  StockRepository stockRepository;
    @Autowired
    private  IStockMapper stockMapper;


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

    @Override
    public int getStockQte(UUID stockId) {
        var stock=stockRepository.findById(stockId)
                .orElseThrow(()-> new NoSuchElementException("stock n'exite pas"));
        return stock.getStockQte();
    }
}
