package poo.examfinal.repository;

import org.springframework.stereotype.Repository;
import poo.examfinal.model.MovementType;
import poo.examfinal.model.StockMovement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository {
    public int getStockByProductId(String productId) {
        String sql = """
        SELECT COALESCE(
            SUM(
                CASE
                    WHEN type = 'IN' THEN quantity
                    WHEN type = 'OUT' THEN -quantity
                    ELSE 0
                END
            ), 0
        ) AS stock
        FROM stock_movement
        WHERE product_id = ?
        """;

        try (
                var connection = DriverManager.getConnection("","","");
        var preparedStatement = connection.prepareStatement(sql)
    ) {
            preparedStatement.setString(1, productId);

            var resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("stock");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }


}