package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationService {

    private final LocationRepository locationRepository;
    private final ObjectMapper objectMapper;

    public LocationService(LocationRepository locationRepository, ObjectMapper objectMapper) {
        this.locationRepository = locationRepository;
        this.objectMapper = objectMapper;
    }

    public Location createLocation(String cityName, String longitude, String latitude, String region, String country) {
        int parsedLongitude;
        int parsedLatitude;

        try {
            parsedLongitude = Integer.parseInt(longitude);
            parsedLatitude = Integer.parseInt(latitude);

            // todo split it to many specific cases
            if (cityName == null || country == null || cityName.isBlank() || country.isBlank() ||
                    parsedLongitude >= 90 || parsedLongitude <= -90 || parsedLatitude >= 180 || parsedLatitude <= -180) {
                throw new IllegalArgumentException("Błędne dane. Nazwa miasta i kraju nie może być pusta." +
                        "Długość geograficzna powinna być z przedziału (-90,90), " +
                        "a szerokość geograficzna z przedziału (-180,180)");
            }
        } catch (NumberFormatException e) {
            // todo create a new IllegalArgumentException("message")
            IllegalArgumentException exception = (IllegalArgumentException) e;
        }

        // todo you can use parsedLongitude and parsedLatitude instead of using Integer.parseInt(longitude)
        //  move it to a 'try' block
        Location location = new Location(cityName, Integer.parseInt(longitude), Integer.parseInt(latitude), region, country);
        return locationRepository.createLocation(location);
    }
}

