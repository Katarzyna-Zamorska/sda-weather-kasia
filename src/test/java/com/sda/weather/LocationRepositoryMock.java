package com.sda.weather;

public class LocationRepositoryMock implements LocationRepository {
    @Override
    public Location createLocation(Location location) {
        location.setId(1L);
        return location;
    }
}
