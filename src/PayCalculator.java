/**
 * Created by dzmitry.karayedau on 13-Apr-17.
 */
public class PayCalculator {
    private final static float MIN_PRICE_PER_HOUR = 8;
    private final static float MAX_HOURS_PER_WEEK = 60;
    private final static float LIMIT_HOURS_TO_KOEFF = 40;
    private final static float AFTER_LIMIT_KOEFFICIENT = 1.5f;


    public static float calculatePay(float pricePerHour, float workingHours) throws HoursOverLimitException, PriceOverLimitException {
        validateData(pricePerHour, workingHours);
        float paydHours = PayCalculator.calculatePaydHours(workingHours);
        return paydHours * pricePerHour;
    }

    private static float calculatePaydHours(float workingHours) {
        if (workingHours <= LIMIT_HOURS_TO_KOEFF) {
            return workingHours;
        } else {
            float overShapeHours = workingHours - LIMIT_HOURS_TO_KOEFF;
            return LIMIT_HOURS_TO_KOEFF + overShapeHours * AFTER_LIMIT_KOEFFICIENT;
        }
    }

    private static void validateData(float pricePerHour, float workingHours) throws HoursOverLimitException, PriceOverLimitException {
        if (pricePerHour < MIN_PRICE_PER_HOUR) {
            throw new PriceOverLimitException("Price " + pricePerHour + " lower then minimum " + MIN_PRICE_PER_HOUR);
        }
        if (workingHours > MAX_HOURS_PER_WEEK) {
            throw new HoursOverLimitException("Working hours " + workingHours + " higher then maximum " + MAX_HOURS_PER_WEEK);
        }
    }

}
