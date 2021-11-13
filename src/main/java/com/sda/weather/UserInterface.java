package com.sda.weather;

import java.util.Scanner;

public class UserInterface {

    private final LocationController locationController;

    public UserInterface(com.sda.weather.LocationController locationController) {
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
                case 1: // tu dodaje wpis do bazy
                    createEntry();
                    break;
                case 2: // tu wyświetlam dodane aktualne lokalizacje
                    getActualAddedEntries();
                    break;
                case 3:// tu pobieram warunki pogodwe
                    getWeather();
                    break;
                case 0: //tu wychodzę z aplikacji
                    return;
            }
        }
    }

    private void getWeather() {
    }

    private void getActualAddedEntries() {
    }

    private void createEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę miasta");
        String cityName = scanner.nextLine();
        System.out.println("Podaj długość geograficzną");
        String longitude = scanner.nextLine();
        System.out.println("Podaj długość geograficzną");
        String latitude = scanner.nextLine();
        System.out.println("Podaj region");
        String region = scanner.nextLine();
        System.out.println("Podaj nazwę kraju");
        String country = scanner.nextLine();

        String requestData = String.format("{\"cityName\":\"%s\", \"longitude\":\"%s\", \"latitude\":\"%s\", \"region\":\"%s\", \"country\":\"%s\"}");

    }
}
