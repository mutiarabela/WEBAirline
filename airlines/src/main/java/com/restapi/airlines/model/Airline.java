package com.restapi.airlines.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Airline {
    @NotNull(message="Airline ID must be filled")
    private int idAirline;

    @NotBlank(message="Airline name must be filled")
    @Size(min=2, message="Airline name must be filled")
    private String nameAirline;

    @NotBlank(message="Type of plane must be filled")
    private String typeAirline;

    @NotBlank(message="Airport Origin must be filled")
    private String airportOriginAirline;

    @NotBlank(message="Airport Destination must be filled")
    private String airportDestinationAirline;

    @NotBlank(message="Destination name must be filled")
    private String destinationAirline;

    @NotNull(message="Price must be filled")
    private double priceAirline = 0.00;

    @NotNull
    private double discountAirline = 0;
}
