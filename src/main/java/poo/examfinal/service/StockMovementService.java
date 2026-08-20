package poo.examfinal.service;

import org.springframework.stereotype.Service;
import poo.examfinal.model.StockMovement;

import java.util.List;

@Service
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

    public List<StockMovement> getStockMovementsByProductId(Long productId) {
        return stockMovementRepository.findByProductId(productId);
    }

    public StockMovement createStockMovement(
            StockMovement stockMovement
    ) {
        return stockMovementRepository.save(stockMovement);
    }
}
