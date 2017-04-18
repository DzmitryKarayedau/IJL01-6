package com.emerline.ijl01_6.utils;

import com.emerline.ijl01_6.exceptions.HoursOverLimitException;
import com.emerline.ijl01_6.exceptions.PriceOverLimitException;

import java.math.BigDecimal;

/**
 * Created by dzmitry.karayedau on 13-Apr-17.
 */
public class PayCalculator {
    private final static int MIN_PRICE_PER_HOUR = 8;
    private final static int MAX_HOURS_PER_WEEK = 60;
    private final static int LIMIT_HOURS_TO_KOEFF = 40;
    private final static BigDecimal AFTER_LIMIT_KOEFFICIENT = new BigDecimal(1.5);
    private final static int FRACTION_DIGITS = 2;


    public static BigDecimal calculatePay(BigDecimal pricePerHour, BigDecimal workingHours) throws HoursOverLimitException, PriceOverLimitException {
        validateData(pricePerHour, workingHours);
        BigDecimal paydHours = PayCalculator.calculatePaydHours(workingHours);
        return pricePerHour.multiply(paydHours).setScale(FRACTION_DIGITS, BigDecimal.ROUND_HALF_UP);
    }

    private static BigDecimal calculatePaydHours(BigDecimal workingHours) {
        if (workingHours.compareTo(new BigDecimal(LIMIT_HOURS_TO_KOEFF)) <= 0) {
            return workingHours;
        } else {
            BigDecimal overShapeHours = workingHours.add(new BigDecimal(LIMIT_HOURS_TO_KOEFF * -1));
            return overShapeHours.multiply(AFTER_LIMIT_KOEFFICIENT).add(new BigDecimal(LIMIT_HOURS_TO_KOEFF));
        }
    }

    private static void validateData(BigDecimal pricePerHour, BigDecimal workingHours) throws HoursOverLimitException, PriceOverLimitException {
        if (pricePerHour.compareTo(new BigDecimal(MIN_PRICE_PER_HOUR)) == -1) {
            throw new PriceOverLimitException(String.format("Price %f lower then minimum %d", pricePerHour, MIN_PRICE_PER_HOUR));
        }
        if (workingHours.compareTo(new BigDecimal(MAX_HOURS_PER_WEEK)) == 1) {
            throw new HoursOverLimitException(String.format("Working hours %f higher then maximum %d", workingHours, MAX_HOURS_PER_WEEK));
        }
    }

}
