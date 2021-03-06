package com.emerline.ijl01_6;

import com.emerline.ijl01_6.exceptions.HoursOverLimitException;
import com.emerline.ijl01_6.exceptions.PriceOverLimitException;
import com.emerline.ijl01_6.utils.PayCalculator;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws HoursOverLimitException, PriceOverLimitException {
        Scanner in = new Scanner(System.in);
        BigDecimal workingHours;
        BigDecimal pricePerHour;

        try {
            System.out.print("Working hours count: ");
            workingHours = in.nextBigDecimal();
            System.out.print("Price per hour: ");
            pricePerHour = in.nextBigDecimal();
            System.out.printf("Salary = %.2f%n ", PayCalculator.calculatePay(pricePerHour, workingHours));
        } catch (InputMismatchException e) {
            System.err.println("Wrong input data");
        } catch (HoursOverLimitException e) {
            System.err.println("Working hours over limit");
        } catch (PriceOverLimitException e) {
            System.err.println("Price over limit");
        }

    }
}
