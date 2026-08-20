package poo.examfinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poo.examfinal.model.StockMovement;
import poo.examfinal.service.ProductService;
import poo.examfinal.service.StockMovementService;

import java.util.List;

@RestController
public class ProductController {

    private final StockMovementService stockMovementService;

    public ProductController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @GetMapping("/products/{id}/stock-movements")
    public List<StockMovement> getStockMovementsByProduct(
            @PathVariable String id
    ) {
        return StockMovementService.getStockMovementsByProductId(id);
    }
    @GetMapping("/products/{id}/stock")
    public int getProductStock(@PathVariable Long id) {
        return ProductService.getProductStock(id);
    }
}
