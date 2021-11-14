package com.sda.weather;

public class LocationDTO {
    private String cityName;
    private String longitude;
    private String latitude;
    private String region;
    private String country;

    public LocationDTO() {
    }

    public LocationDTO(String cityName, String longitude, String latitude, String region, String country) {
        this.cityName = cityName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.region = region;
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "cityName='" + cityName + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
