package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Scanner scanner = new Scanner(System.in);

        // What are my known values?
        double priceOfOptionTollTag = 3.95;
        double priceOfOptionGPS = 2.95;
        double priceOfOptionRoadsideAssistance = 3.95;
        double priceOfBasicCarRentalPerDay = 29.99;
        float percentSurchargeForUnderage = 0.30f;
        int userageLimit = 25;


        // What values do I need to get from the user?
        System.out.print("When do you want to rent the car?: ");
        String pickupDate = scanner.nextLine();


        System.out.print("How many days do you need it?:");
        int numberOfDays = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Do you want a toll tag (Y/N): ");
        boolean optionTollTag = scanner.nextLine().equalsIgnoreCase("y");



        System.out.print("Do you want a GPS (Y/N): ");
        boolean optionGPS = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Do you want Roadside Assistance: (Y/N): ");
        boolean optionRoadsideAssistance = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("How old are you?:");
        int age = scanner.nextInt();
        scanner.nextLine();


        // What needs to be calculated?
        double basicCarRentalAmount = numberOfDays * priceOfBasicCarRentalPerDay;

        double optionPerDayCumulative = (optionTollTag) ? priceOfOptionTollTag: 0;
        optionPerDayCumulative += (optionGPS) ? priceOfOptionGPS: 0;
        optionPerDayCumulative += (optionRoadsideAssistance) ? priceOfOptionRoadsideAssistance: 0;

        double optionAmounts = optionPerDayCumulative * numberOfDays;

        double underageSurcharge = 0;
        if (age < userageLimit){
            underageSurcharge = basicCarRentalAmount * percentSurchargeForUnderage;
        }

        double totalCost = basicCarRentalAmount + optionAmounts + underageSurcharge;


        // Display the results.
        System.out.println("Here is the quote for your rental: ");

        System.out.printf("Basic Car Rental:       %.2f\n", basicCarRentalAmount);

        System.out.printf("Options:                %.2f\n", optionAmounts);

        System.out.printf("Underage Surcharge:     %.2f\n", underageSurcharge);

        System.out.printf("Total:                  %.2f\n", totalCost);
        }
}
