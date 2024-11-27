package com.example.ms_vehicle_season_price;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleSeasonPriceService {

    /**
     * VehicleSeasonPriceRepository
     */
    private final VehicleSeasonPriceRepository vehicleSeasonPriceRepository;

    /**
     * Constructor
     * @param vehicleSeasonPriceRepository the vehicle season price repository
     */
    public VehicleSeasonPriceService(VehicleSeasonPriceRepository vehicleSeasonPriceRepository) {
        this.vehicleSeasonPriceRepository = vehicleSeasonPriceRepository;
    }

    /**
     * Get daily rate by vehicle type and season
     *
     * @param vehicleType the vehicle type
     * @param season      the season
     * @return the daily rate
     */
    public Double getDailyRate(String vehicleType, String season) {
        Optional<VehicleSeasonPrice> vehicleSeasonPrice = vehicleSeasonPriceRepository.findByType(vehicleType);

        return vehicleSeasonPrice.map(seasonPrice -> seasonPrice.getPriceBySeason(season))
                .orElseThrow(() -> new VehicleSeasonPriceNotFoundException(vehicleType, season));
    }
}
