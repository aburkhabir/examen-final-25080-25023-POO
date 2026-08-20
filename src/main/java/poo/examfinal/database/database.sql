CREATE TABLE product (
                         id VARCHAR(50) PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description TEXT,
                         unit_price DECIMAL(10, 2) NOT NULL
);CREATE TABLE stock_movement (
                                  id VARCHAR(50) PRIMARY KEY,
                                  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
                                  quantity INTEGER NOT NULL,
                                  type VARCHAR(3) NOT NULL,

                                  product_id VARCHAR(50) NOT NULL,

                                  FOREIGN KEY (product_id) REFERENCES product(id),

                                  CHECK (type IN ('IN', 'OUT'))
  );