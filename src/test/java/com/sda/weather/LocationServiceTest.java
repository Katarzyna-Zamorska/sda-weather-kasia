package com.sda.weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

class LocationServiceTest {
    private LocationService locationService;

    @BeforeEach
    void setUp() {
        LocationRepository locationRepository = new LocationRepositoryMock();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        locationService = new LocationService(locationRepository, objectMapper);
    }

    @Test
    void createLocation_whenEverythingIsCorrect_returnsNewLocation() {
        //when
        Location location = locationService.createLocation("Katowice", "75", "175",
                "ślask", "Polska");

        // then
        assertThat(location.getId()).isNotNull();
        assertThat(location.getCityName()).isEqualTo("Katowice");
        assertThat(location.getLongitude()).isEqualTo(75);
        assertThat(location.getLatitude()).isEqualTo(175);
        assertThat(location.getRegion()).isEqualTo("ślask");
        assertThat(location.getCountry()).isEqualTo("Polska");

    }

    @Test
    void createLocation_whenRegionIsEmpty_returnsNewLocation() {
        //when
        Location location = locationService.createLocation("Katowice", "75", "175",
                "", "Polska");

        // then
        assertThat(location.getId()).isNotNull();
        assertThat(location.getCityName()).isEqualTo("Katowice");
        assertThat(location.getLongitude()).isEqualTo(75);
        assertThat(location.getLatitude()).isEqualTo(175);
        assertThat(location.getRegion()).isEmpty();
        assertThat(location.getCountry()).isEqualTo("Polska");
    }

    @Test
    void createLocation_whenLongitudeIsGreaterThanCorrectValue() {
        //when
        Location location = locationService.createLocation("Katowice", "95", "175",
                "", "Polska");

        // then

    }

    @Test
    void createLocation_whenLongitudeIsLowerThanCorrectValue() {
        //when
        Location location = locationService.createLocation("Katowice", "-95", "175",
                "", "Polska");

        // then
    }

    @Test
    void createLocation_whenLatitudeIsGreaterThanCorrectValue() {
        //when
        Location location = locationService.createLocation("Katowice", "95", "185",
                "", "Polska");
        // then
    }

    @Test
    void createLocation_whenLatitudeIsLowerThanCorrectValue() {
        //when
        Location location = locationService.createLocation("Katowice", "95", "-185",
                "", "Polska");

        // then
    }


    @Test
    void createLocation_whenCityIsEmpty_throwsAnException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.createLocation("   ", "85", "140", "slask", "Polska"));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLocation_whenCountryIsEmpty_throwsAnException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.createLocation("Katowice", "85", "140", "slask", " "));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
