package poo.examfinal.repository;

import org.springframework.stereotype.Repository;
import poo.examfinal.model.MovementType;
import poo.examfinal.model.StockMovement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StockMovementRepository {

    public List<StockMovement> findByMovementsType(MovementType movementType) {
        List<StockMovement> movements = new ArrayList<>();

        String sql = """
            SELECT id, product_id, movement_type, quantity
            FROM stock_movement
            WHERE movement_type = ?
            """;

        try (
                var connection = DriverManager.getConnection(
                        "",
                        "",
                        ""
                );
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, movementType.name());

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                StockMovement movement = new StockMovement(
                        rs.getString("id"),
                        rs.getString("product_id"),
                        MovementType.valueOf(rs.getString("movement_type")),
                        rs.getInt("quantity")
                );

                movements.add(movement);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movements;
    }



    public void saveStockMovement(StockMovement stockMovement) {
        String sql = "INSERT INTO stock_movement(id, createdAt,quantity, type, product_id) VALUES (?, ?, ?, ?)";

        try (
                var connection = DriverManager.getConnection(
                        "",
                        "",
                        ""
                );

                var preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, stockMovement.getId());
            preparedStatement.setTimestamp(2, Timestamp.from(stockMovement.getCreatedAt()));
            preparedStatement.setInt(3, stockMovement.getQuantity());
            preparedStatement.setString(4, stockMovement.getMovementType().name());
            preparedStatement.setString(5,stockMovement.getProduct().getId());



            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StockMovement> getStockMovementByProductId(String productId) {
        List<StockMovement> movements = new ArrayList<>();

        String sql = """
            SELECT *
            FROM stock_movement
            WHERE product_id = ?
            """;

        try (
                var connection = DriverManager.getConnection("","","");
        var preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, productId);

            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                 resultSet.getString("id");
                 resultSet.getInt("quantity");
                 resultSet.getString("type");
                 resultSet.getTimestamp(Timestamp.from(StockMovement.getCreatedAt());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movements;
    }



}