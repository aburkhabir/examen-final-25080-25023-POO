package poo.examfinal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
public class StockMovement {
    private String id;
    private Instant createdAt;
    private MovementType movementType;
    private int quantity;
    private Product product;

    public StockMovement(String id, String productId, MovementType movementType, int quantity) {
    }
}
