package poo.examfinal.controller;

import org.springframework.web.bind.annotation.*;
import poo.examfinal.model.Product;
import poo.examfinal.model.StockMovement;
import poo.examfinal.service.ProductService;
import poo.examfinal.service.StockMovementService;

import java.awt.*;

@RestController
public class ProductController {
    private final ProductService productService;
    private final StockMovementService stockMovementService;

    public ProductController(
            ProductService productService,
            StockMovementService stockMovementService
    ) {
        this.productService = productService;
        this.stockMovementService = stockMovementService;
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    public Product getProductById(
            @PathVariable Long id
    ) {
        return productService.getProductById(id);
    }
    @PostMapping
    public Product createProduct(
            @RequestBody Product product
    ) {
        return productService.createProduct(product);
    }


    @GetMapping("/{id}/stock")
    public int getProductStock(
            @PathVariable Long id
    ) {
        return productService.getProductStock(id);
    }


    @GetMapping("/{id}/stock-movements")
    public List<StockMovement> getStockMovementsByProduct(
            @PathVariable Long id
    ) {
        return stockMovementService
                .getStockMovementsByProductId(id);
    }

}
