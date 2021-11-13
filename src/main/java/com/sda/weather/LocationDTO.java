package com.sda.weather;

import lombok.Data;

@Data
public class LocationDTO {
    String cityName; // todo private x5
    String longitude;
    String latitude;
    String region;
    String country;
}
