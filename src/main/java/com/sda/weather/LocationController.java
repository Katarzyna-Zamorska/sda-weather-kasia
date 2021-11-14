package com.sda.weather;

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
            LocationDTO createdLocation = new LocationDTO(location.getCityName(), location.getLongitude(), location.getLatitude(), location.getRegion(), location.getCountry());
            return objectMapper.writeValueAsString(createdLocation);
        } catch (Exception e) { // todo catch just IllegalArgumentException
            return "{\"errorMessage\": \"" + e.getMessage() + "\"}";
        }

    }
}
