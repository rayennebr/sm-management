package com.rayennebr.smmanagement.controllers;

import com.rayennebr.smmanagement.dtos.Response;
import com.rayennebr.smmanagement.entities.Product;
import com.rayennebr.smmanagement.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin("*")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    Response<List<Product>>getAllProduct()
    {
        try{
            return Response.<List<Product>>builder()
                    .status(HttpStatus.OK)
                    .data(productService.getAllProduct())
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<List<Product>>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/")
    Response<Product> addProduct(@RequestBody Product product)
    {
        try{
            return Response.<Product>builder()
                    .status(HttpStatus.OK)
                    .data(productService.saveProduct(product))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Product>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PutMapping("/{prodId}")
    Response<Product>updateProduct(@PathVariable UUID prodId,@RequestBody Product product)
    {
        try{
            return Response.<Product>builder()
                    .status(HttpStatus.OK)
                    .data(productService.updateProduct(prodId,product))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Product>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @DeleteMapping("/{prodId}")
    Response<Product>deleteProduct(@PathVariable UUID prodId)
    {
        try{
            return Response.<Product>builder()
                    .status(HttpStatus.OK)
                    .data(productService.deleteProduct(prodId))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<Product>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

    @GetMapping("/byCat/{catUID}")
    Response<List<Product>>findAllByCatId(@PathVariable UUID catUID)
    {
        try{
            return Response.<List<Product>>builder()
                    .status(HttpStatus.OK)
                    .data(productService.findAllByCatId(catUID))
                    .message("success !")
                    .build();
        } catch (Exception e) {
            return Response.<List<Product>>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(null)
                    .message(e.getMessage())
                    .build();
        }
    }

}
