package poo.examfinal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter

public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private List<StockMovement> stockMovements;
}
