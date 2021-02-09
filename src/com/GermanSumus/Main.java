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

        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        System.out.print("Mortgage Amount: ");
        float principal = Float.parseFloat(scanner.nextLine());
        System.out.print("Annual Percentage Rate: ");
        float apr = Float.parseFloat(scanner.nextLine())/TO_PERCENT;
        System.out.print("Years: ");
        int time = Integer.parseInt(scanner.nextLine())*MONTHS_IN_YEAR;

        float rate = apr/MONTHS_IN_YEAR;
        double x = principal * rate * Math.pow((1+rate), time);
        double y = Math.pow((1+rate), time) - 1;
        double mortgagePayment =  x/y;
        System.out.println(currency.format(mortgagePayment));
    }
}
