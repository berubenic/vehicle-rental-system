CREATE TABLE vehicle_season_prices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    winter_price DECIMAL(10, 2) NOT NULL,
    spring_price DECIMAL(10, 2) NOT NULL,
    summer_price DECIMAL(10, 2) NOT NULL,
    fall_price DECIMAL(10, 2) NOT NULL
);