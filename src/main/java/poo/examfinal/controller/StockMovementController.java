package poo.examfinal.controller;

import org.springframework.web.bind.annotation.*;
import poo.examfinal.model.StockMovement;
import poo.examfinal.service.StockMovementService;
import java.util.List;

@RestController
public class StockMovementController {

    private final StockMovementService stockMovementService;

    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @GetMapping("/stock-movements")
    public List<StockMovement> getStockMovements(
            @RequestParam String MovementType
    ) {
        return stockMovementService.getStockMovementsByType(MovementType);
    }

    @PostMapping("/stock-movements")
    public StockMovement createStockMovement(
            @RequestBody StockMovement stockMovement
    ) {
        return stockMovementService.createStockMovement(stockMovement);
    }
}
