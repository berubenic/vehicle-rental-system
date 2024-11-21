package com.example.ms_vehicle_season_price;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
class LoadDatabase {

    private static final List<Map<String, Object>> DATA = List.of(
            Map.of(
                    "vehicleType", "Compact",
                    "pricing", Map.of(
                            "Spring", 45,
                            "Summer", 50,
                            "Fall", 43,
                            "Winter", 40
                    )
            ),
            Map.of(
                    "vehicleType", "Sedan",
                    "pricing", Map.of(
                            "Spring", 55,
                            "Summer", 60,
                            "Fall", 53,
                            "Winter", 50
                    )
            ),
            Map.of(
                    "vehicleType", "SUV",
                    "pricing", Map.of(
                            "Spring", 65,
                            "Summer", 70,
                            "Fall", 63,
                            "Winter", 60
                    )
            ),
            Map.of(
                    "vehicleType", "Convertible",
                    "pricing", Map.of(
                            "Spring", 75,
                            "Summer", 80,
                            "Fall", 73,
                            "Winter", 70
                    )
            ),
            Map.of(
                    "vehicleType", "Truck",
                    "pricing", Map.of(
                            "Spring", 85,
                            "Summer", 90,
                            "Fall", 83,
                            "Winter", 80
                    )
            )
    );


    /**
     * Logger for this class.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            LoadDatabase.class
    );

    @Bean
    CommandLineRunner initDatabase(
            final VehicleSeasonPriceRepository vehicleSeasonPriceRepository
    ) {
        return args -> {
            DATA.forEach(data -> {
                final String vehicleType = (String) data.get("vehicleType");
                final Map<String, Integer> pricing = (Map<String, Integer>) data.get("pricing");

                this.preloadVehicleSeasonPrice(
                        vehicleSeasonPriceRepository,
                        vehicleType,
                        pricing.get("Winter").doubleValue(),
                        pricing.get("Spring").doubleValue(),
                        pricing.get("Summer").doubleValue(),
                        pricing.get("Fall").doubleValue()
                );
            });
        };
    }

    private void preloadVehicleSeasonPrice(
            final VehicleSeasonPriceRepository vehicleSeasonPriceRepository,
            final String type,
            final Double winterPrice,
            final Double springPrice,
            final Double summerPrice,
            final Double fallPrice
    ) {
        vehicleSeasonPriceRepository.findByType(type).orElseGet(() -> {
            this.log(vehicleSeasonPriceRepository.save(
                    new VehicleSeasonPrice(
                            type,
                            winterPrice,
                            springPrice,
                            summerPrice,
                            fallPrice
                    )
            ));
            return vehicleSeasonPriceRepository.findByType(type).orElse(null);
        });
    }

    private void log(final Object object) {
        LOG.info("Preloading {}", object);
    }
}