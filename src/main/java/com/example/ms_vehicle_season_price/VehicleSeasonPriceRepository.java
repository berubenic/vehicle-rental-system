package com.example.ms_vehicle_season_price;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleSeasonPriceRepository extends JpaRepository<VehicleSeasonPrice, Long> {
    /**
     * Find a vehicle season price by type.
     *
     * @param type vehicle type
     * @return the product
     */
    Optional<VehicleSeasonPrice> findByType(String type);

}
