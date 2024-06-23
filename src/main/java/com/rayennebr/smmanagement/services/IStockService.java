package com.rayennebr.smmanagement.services;

import com.rayennebr.smmanagement.entities.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IStockService {
    Stock saveStock(Stock Stock);
    Stock updateStock(UUID stockId, Stock Stock);
    Stock deleteStock(UUID stockId);
    List<Stock> getAllStock();

    int getStockQte(UUID stockId);
}
