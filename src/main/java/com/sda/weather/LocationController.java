package com.sda.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationController {
 private final ObjectMapper objectMapper;
 private final LocationService locationService;

    public LocationController(ObjectMapper objectMapper, LocationService locationService) {
        this.objectMapper = objectMapper;
        this.locationService = locationService;
    }

    /*
    String cityName;
    String longitude;
    String latitude;
    String region;
    String country;
 */
    public String addLocation(String data) {

        try {
            LocationDTO locationDTO= objectMapper.readValue(data, LocationDTO.class);
            String cityName= locationDTO.getCityName();
            String longitude = locationDTO.getLongitude();
            String latitude = locationDTO.getLatitude();
            String region = locationDTO.getRegion();
            String country = locationDTO.getCountry();
            Location location = locationService.createEntry(cityName, longitude, latitude, region, country);
            LocationDTO createdEntry = new LocationDTO();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return data;
    }


}
