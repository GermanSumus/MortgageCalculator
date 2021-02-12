package com.GermanSumus;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Collect user input. Principal, Rate, Years.
    // Calculate mortgage payment.
    // Print out mortgage payment.
        final byte TO_PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;
        float principal;
        float apr;
        int time;

        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        while (true) {
            System.out.print("Mortgage Amount: ");
            principal = Float.parseFloat(scanner.nextLine());
            if ((principal >= 1_000) && (principal <= 1_000_000))
                break;
            else
                System.out.println("Enter value between 1K and 1M.");
        }

        while (true) {
            System.out.print("Annual Percentage Rate: ");
            apr = Float.parseFloat(scanner.nextLine()) / TO_PERCENT;
            if ((apr > 0) && (apr <= 30))
                break;
            else
                System.out.println("Enter value between 0 and 30");
        }

        while (true) {
            System.out.print("Years: ");
            time = Integer.parseInt(scanner.nextLine());
            if ((time > 0) && (time <= 30)) {
                time = time * MONTHS_IN_YEAR;
                break;
            }
            else
                System.out.println("Enter value between 0 and 30");
        }

        float rate = apr/MONTHS_IN_YEAR;
        double x = principal * rate * Math.pow((1+rate), time);
        double y = Math.pow((1+rate), time) - 1;
        double mortgagePayment =  x/y;

        System.out.println(currency.format(mortgagePayment));
    }
}
