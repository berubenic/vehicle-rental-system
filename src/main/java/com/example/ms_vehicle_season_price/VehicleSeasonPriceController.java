package com.example.ms_vehicle_season_price;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vehicle-season-price")
public class VehicleSeasonPriceController {

    /**
     * VehicleSeasonPriceService
     */
    private final VehicleSeasonPriceService vehicleSeasonPriceService;

    /**
     * Constructor
     * @param vehicleSeasonPriceService the vehicle season price service
     */
    public VehicleSeasonPriceController(VehicleSeasonPriceService vehicleSeasonPriceService) {
        this.vehicleSeasonPriceService = vehicleSeasonPriceService;
    }

    /**
     * Get daily rate by vehicle type and season
     *
     * @param vehicleType the vehicle type
     * @param season      the season
     * @return the daily rate
     */
    @GetMapping("/daily-rate")
    public Map<String, Object> getDailyRate(
            @RequestParam("vehicleType") String vehicleType,
            @RequestParam("season") String season
    ) {
        if (vehicleType == null || season == null) {
            // todo: throw exception
        }

        Map<String, Object> response = new HashMap<>();

        Double rate = vehicleSeasonPriceService.getDailyRate(vehicleType, season);

        response.put("dailyRate", rate);
        response.put("vehicleType", vehicleType);
        response.put("season", season);
        response.put("success", rate != null);

        return response;
    }
}
