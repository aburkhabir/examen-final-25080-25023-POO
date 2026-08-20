package poo.examfinal.service;

import org.springframework.stereotype.Service;
import poo.examfinal.model.Product;

import java.util.List;

@Service
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


    public Product getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public int getProductStock(Long productId) {
        return stockMovementRepository.calculateStock(productId);
    }
}
