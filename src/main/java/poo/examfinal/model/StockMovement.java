package poo.examfinal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@AllArgsConstructor
@Getter
@Setter
public class StockMovement {
    private String id;
    private Instant createdAt;
    private MovementType movementType;
    private int quantity;
}
