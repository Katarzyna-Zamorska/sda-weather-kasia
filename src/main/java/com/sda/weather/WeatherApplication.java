package com.sda.weather;

public class WeatherApplication {

    public static void main(String[] args) {
        // todo create UserInterface and perform run() method
        LocationController locationController = new LocationController();
        UserInterface userInterface = new UserInterface(locationController);
        userInterface.run();
        userInterface.createEntry();
    }
}
