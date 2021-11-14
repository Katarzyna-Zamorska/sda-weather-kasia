package com.sda.weather;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LocationDTO {
    private String cityName;
    private String longitude;
    private String latitude;
    private String region;
    private String country;
}
