package com.sda.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationController {
    private final ObjectMapper objectMapper;
    private final LocationService locationService;

    public String addLocation(String data) {
        try {
            LocationDTO locationDTO = objectMapper.readValue(data, LocationDTO.class);
            String cityName = locationDTO.getCityName();
            String longitude = locationDTO.getLongitude();
            String latitude = locationDTO.getLatitude();
            String region = locationDTO.getRegion();
            String country = locationDTO.getCountry();
            Location location = locationService.createLocation(cityName, longitude, latitude, region, country);
            LocationDTO createdLocation = new LocationDTO(location.getCityName(), String.valueOf(location.getLongitude()),
                   String.valueOf(location.getLatitude()), location.getRegion(), location.getCountry());
            return objectMapper.writeValueAsString(createdLocation);
        } catch (IllegalArgumentException | JsonProcessingException e) {
            return "{\"errorMessage\": \"" + e.getMessage() + "\"}";
        }

    }
}
