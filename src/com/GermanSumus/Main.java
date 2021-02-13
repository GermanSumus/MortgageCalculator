package com.GermanSumus;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    /*
     Collect user input. Principal, Rate, Years.
     Calculate mortgage payment.
     Print out mortgage payment.
    */
        final byte TO_PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;
        float principal = 0;
        float apr = 0;
        float time = 0;

        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        while (true) {
            System.out.print("Mortgage Amount: ");
            String input = scanner.nextLine();
            if (verifyNumber(input))
                    principal = Float.parseFloat(input);
            if ((principal >= 1_000) && (principal <= 1_000_000))
                break;
            else
                System.out.println("Enter value between 1K and 1M.");
        }

        while (true) {
            System.out.print("Annual Percentage Rate: ");
            String input = scanner.nextLine();
            if (verifyNumber(input))
                apr = Float.parseFloat(input);
            if ((apr > 0) && (apr <= 30)) {
                apr = apr / TO_PERCENT;
                break;
            }
            else
                System.out.println("Enter value between 0 and 30");
        }

        while (true) {
            System.out.print("Years: ");
            String input = scanner.nextLine();
            if (verifyNumber(input))
                time = Float.parseFloat(input);
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

        // Verify user input if its a number
        public static boolean verifyNumber (String input) {
            try {
                float number = Float.parseFloat(input);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
}
