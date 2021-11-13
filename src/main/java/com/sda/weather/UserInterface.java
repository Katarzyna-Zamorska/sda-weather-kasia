package com.sda.weather;

import java.util.Scanner;

public class UserInterface {

    private final LocationController locationController;

    public UserInterface(LocationController locationController) {
        this.locationController = locationController;
    }

    public void run() {
        System.out.println("Aplikacja jest uruchomiona\n");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Witaj w aplikacji pogodowej, co chcesz zrobić?");
            System.out.println("1.Dodać nową lokalizację");
            System.out.println("2.Wyświetlić aktualnie dodane lokalizacje");
            System.out.println("3.Pobrać warunki pogodowe");
            System.out.println("0.Zamknąć aplikacje");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createEntry();
                    break;
                case 2:
                    getActualAddedEntries();
                    break;
                case 3:
                    getWeather();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void getWeather() {
    }

    public void getActualAddedEntries() {
    }

    public void createEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę miasta");
        String cityName = scanner.nextLine();
        System.out.println("Podaj długość geograficzną");
        String longitude = scanner.nextLine();
        System.out.println("Podaj szerokość geograficzną");
        String latitude = scanner.nextLine();
        System.out.println("Podaj region");
        String region = scanner.nextLine();
        System.out.println("Podaj nazwę kraju");
        String country = scanner.nextLine();


        String requestData = String.format("{\"cityName\":\"%s\", \"longitude\":\"%s\", \"latitude\":\"%s\", \"region\":\"%s\", \"country\":\"%s\"}",
                cityName, longitude, latitude, region, country);
        String response= locationController.addLocation(requestData);

    }
}