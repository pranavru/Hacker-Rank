import java.util.*;
import java.text.*;
import java.lang.String;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        //Double d = new Double(payment);
        // Write your code here.
        String us = NumberFormat.getCurrencyInstance(new Locale("en", "US"))
        .format(payment);
        String india = "Rs." + String.format("%,.2f", payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA)
        .format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE)
        .format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}

