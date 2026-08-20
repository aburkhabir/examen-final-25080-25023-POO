package poo.examfinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import poo.examfinal.model.StockMovement;

import java.util.List;

public class StockMovementController {
    private final StockMovementService stockMovementService;

    public StockMovementController(
            StockMovementService stockMovementService
    ) {
        this.stockMovementService = stockMovementService;
    }


    @GetMapping
    public List<StockMovement> getStockMovements(
            @RequestParam(required = false) String type
    ) {

        if (type != null) {
            return stockMovementService
                    .getStockMovementsByType(type);
        }

        return stockMovementService
                .getAllStockMovements();
    }

    @PostMapping
    public StockMovement createStockMovement(
            @RequestBody StockMovement stockMovement
    ) {
        return stockMovementService
                .createStockMovement(stockMovement);
    }
}
