package poo.examfinal.service;

import poo.examfinal.model.Product;
import poo.examfinal.repository.ProductRepository;
import poo.examfinal.repository.StockMovementRepository;

import java.awt.*;

public class ProductService {
    private final ProductRepository productRepository;
    private final StockMovementRepository stockMovementRepository;

    public ProductService(
            ProductRepository productRepository,
            StockMovementRepository stockMovementRepository
    ) {
        this.productRepository = productRepository;
        this.stockMovementRepository = stockMovementRepository;
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public int getProductStock(Long productId) {
        return stockMovementRepository.calculateStock(productId);
    }
}
