package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationController {

    private final ObjectMapper objectMapper;

    public String addLocation(String data) {

        NewEntryDTO newEntry = objectMapper().readValue(data, NewEntryDTO.class);
        String cityName = newEntry.getCityName();
        Long longitude = newEntry.getLongitude();
        Long latitude = newEntry.getLatitude;
        String region = newEntry.getRegion;
        String country = newEntry.getCountry;




    }


}
