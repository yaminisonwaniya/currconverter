Updated currency convertor In java


import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        HashMap<Integer, String> currencyCodes = new HashMap<>();
        HashMap<String, Double> conversionRates = new HashMap<>();

        currencyCodes.put(1, "USD");
        currencyCodes.put(2, "CAD");
        currencyCodes.put(3, "EUR");
        currencyCodes.put(4, "HKD");
        currencyCodes.put(5, "INR");

        conversionRates.put("USD", 1.0);
        conversionRates.put("CAD", 1.25);
        conversionRates.put("EUR", 0.85);
        conversionRates.put("HKD", 7.8);
        conversionRates.put("INR", 74.5);

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");

        try {
            
            System.out.println("Currency converting FROM?");
            displayCurrencies(currencyCodes);
            String fromCode = getCurrencyCode(currencyCodes, sc);


            System.out.println("Currency converting TO?");
            displayCurrencies(currencyCodes);
            String toCode = getCurrencyCode(currencyCodes, sc);

            
            System.out.println("Enter the amount you wish to convert:");
            double amount = sc.nextDouble();

            if (amount < 0) {
                System.out.println("Amount cannot be negative. Please restart the program.");
                return;
            }

            double convertedAmount = convertCurrency(fromCode, toCode, amount, conversionRates);

           
            System.out.printf("%.2f %s is equivalent to %.2f %s.%n", amount, fromCode, convertedAmount, toCode);
            System.out.println("Thank you for using the Currency Converter!");

        } catch (Exception e) {
            System.out.println("An error occurred. Please restart the program and try again.");
        } finally {
            sc.close();
        }
    }

    private static void displayCurrencies(HashMap<Integer, String> currencyCodes) {
        for (int code : currencyCodes.keySet()) {
            System.out.printf("%d: %s\t", code, currencyCodes.get(code));
        }
        System.out.println();
    }

    private static String getCurrencyCode(HashMap<Integer, String> currencyCodes, Scanner sc) {
        int choice = sc.nextInt();
        while (!currencyCodes.containsKey(choice)) {
            System.out.println("Invalid choice. Please select a valid option:");
            choice = sc.nextInt();
        }
        return currencyCodes.get(choice);
    }

    private static double convertCurrency(String fromCode, String toCode, double amount, HashMap<String, Double> conversionRates) {
        double fromRate = conversionRates.get(fromCode);
        double toRate = conversionRates.get(toCode);
        return (amount / fromRate) * toRate;
    }
}