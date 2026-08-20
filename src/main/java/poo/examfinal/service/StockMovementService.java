package poo.examfinal.service;

import poo.examfinal.model.StockMovement;
import poo.examfinal.repository.StockMovementRepository;

import java.awt.*;

public class StockMovementService {
    private final StockMovementRepository stockMovementRepository;

    public StockMovementService(
            StockMovementRepository stockMovementRepository
    ) {
        this.stockMovementRepository = stockMovementRepository;
    }


    public List<StockMovement> getAllStockMovements() {
        return stockMovementRepository.findAll();
    }


    public List<StockMovement> getStockMovementsByType(String type) {
        return stockMovementRepository.findByType(type);
    }

    public List<StockMovement> getStockMovementsByProductId(String productId) {
        return stockMovementRepository.getStockMovementByProductId(productId);
    }
    public StockMovement createStockMovement(
            StockMovement stockMovement
    ) {
        return stockMovementRepository.save(stockMovement);
    }
}
