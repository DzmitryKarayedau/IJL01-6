import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws HoursOverLimitException, PriceOverLimitException {
        Scanner in = new Scanner(System.in);
        float workingHours;
        float pricePerHour;

        try {
            System.out.print("Working hours count: ");
            workingHours = in.nextFloat();
            System.out.print("Price per hour: ");
            pricePerHour = in.nextFloat();
            System.out.print("Salary = " + PayCalculator.calculatePay(pricePerHour, workingHours));
        } catch (InputMismatchException e) {
            System.err.println("Wrong input data");
        } catch (HoursOverLimitException e) {
            System.err.println("Working hours over limit");
        } catch (PriceOverLimitException e) {
            System.err.println("Price over limit");
        }


    }
}
