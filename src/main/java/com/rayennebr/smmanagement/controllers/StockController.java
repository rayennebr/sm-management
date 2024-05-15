package com.rayennebr.smmanagement.controllers;

import com.rayennebr.smmanagement.dtos.Response;
import com.rayennebr.smmanagement.entities.Stock;
import com.rayennebr.smmanagement.services.IStockService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/stock")
@CrossOrigin("*")
public class StockController {
    
    private final IStockService stockService;

    public StockController(IStockService stockService) {
        this.stockService = stockService;
    }


    @GetMapping("/")
    Response<List<Stock>> getAllStock()
    {
        try{
            return Response.<List<Stock>>builder()
                    .status(HttpStatus.OK)
                    .data(stockService.getAllStock())
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<List<Stock>>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/")
    Response<Stock> addStock(@RequestBody Stock stock)
    {
        try{
            return Response.<Stock>builder()
                    .status(HttpStatus.OK)
                    .data(stockService.saveStock(stock))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Stock>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PutMapping("/{stockId}")
    Response<Stock>updateStock(@PathVariable UUID stockId, @RequestBody Stock stock)
    {
        try{
            return Response.<Stock>builder()
                    .status(HttpStatus.OK)
                    .data(stockService.updateStock(stockId,stock))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Stock>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @DeleteMapping("/{stockId}")
    Response<Stock>deleteStock(@PathVariable UUID stockId)
    {
        try{
            return Response.<Stock>builder()
                    .status(HttpStatus.OK)
                    .data(stockService.deleteStock(stockId))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Stock>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }
}
