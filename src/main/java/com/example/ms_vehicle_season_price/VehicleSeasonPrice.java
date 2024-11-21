package com.example.ms_vehicle_season_price;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_season_prices")
public class VehicleSeasonPrice {

    /**
     * The unique identifier of the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Vehicle type.
     */
    @Column(name = "type")
    private String type;

    /**
     * Winter price.
     */
    @Column(name = "winter_price")
    private Double winter_price;

    /**
     * Spring price.
     */
    @Column(name = "spring_price")
    private Double spring_price;

    /**
     * Summer price.
     */
    @Column(name = "summer_price")
    private Double summer_price;

    /**
     * Fall price.
     */
    @Column(name = "fall_price")
    private Double fall_price;


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getWinter_price() {
        return winter_price;
    }

    public void setWinter_price(Double winter_price) {
        this.winter_price = winter_price;
    }

    public Double getSpring_price() {
        return spring_price;
    }

    public void setSpring_price(Double spring_price) {
        this.spring_price = spring_price;
    }

    public Double getSummer_price() {
        return summer_price;
    }

    public void setSummer_price(Double summer_price) {
        this.summer_price = summer_price;
    }

    public Double getFall_price() {
        return fall_price;
    }

    public void setFall_price(Double fall_price) {
        this.fall_price = fall_price;
    }

    public Double getPriceBySeason(String season) {
        return switch (season) {
            case "winter" -> winter_price;
            case "spring" -> spring_price;
            case "summer" -> summer_price;
            case "fall" -> fall_price;
            default -> null;
        };
    }

    // toString()

    @Override
    public String toString() {
        return "VehicleSeasonPrice{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", winter_price='" + winter_price + '\'' +
                ", spring_price='" + spring_price + '\'' +
                ", summer_price='" + summer_price + '\'' +
                ", fall_price='" + fall_price + '\'' +
                '}';
    }

    // Constructors

    public VehicleSeasonPrice() {
    }

    public VehicleSeasonPrice(String type, Double winter_price, Double spring_price, Double summer_price, Double fall_price) {
        this.type = type;
        this.winter_price = winter_price;
        this.spring_price = spring_price;
        this.summer_price = summer_price;
        this.fall_price = fall_price;
    }
}
