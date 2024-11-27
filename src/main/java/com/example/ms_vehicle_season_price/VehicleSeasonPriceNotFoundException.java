package com.example.ms_vehicle_season_price;

public class VehicleSeasonPriceNotFoundException extends RuntimeException {
    /**
     * Constructor.
     *
     * @param type the type of the vehicle
     */
    public VehicleSeasonPriceNotFoundException(final String type, final String season) {
        super("Could not find vehicle type %s".formatted(type) + " and season %s".formatted(season));
    }
}
