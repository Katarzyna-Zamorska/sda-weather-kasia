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
        if (cityName == null || region == null || cityName.isBlank() || region.isBlank()) { // todo region can be empty, country cannot
            throw new IllegalArgumentException("Nazwa miasta i regionu nie mogą być puste");
        }

        int parsedLongitude = Integer.parseInt(longitude); // todo catch NumberFormatException and translate it to IllegalArgumentException
        int parsedLatitude = Integer.parseInt(latitude);

        // todo >= <=
        if (parsedLongitude > 90 || parsedLongitude < -90 || parsedLatitude > 180 || parsedLatitude < -180) {
            throw new IllegalArgumentException("Błędne dane. Długość geograficzna powinna być  z przedziału <-90,90>, a szerokość geograficzna z przedziału <-180, 180>");
        }

        Location location = new Location(cityName, longitude, latitude, region, country);
        return locationRepository.createLocation(location);
    }
}
