package student;

/**
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public class PayStub implements IPayStub {
    /** taxes paid for the current pay period.*/
    private double tax;

    /** taxes paid for the current pay period.*/
    private String name;

    /** pay for the current pay period.*/
    private double netPay;

    /** Year-to-date (YTD) earnings.*/
    private double ytdE;

    /** Year-to-date (YTD) taxes paid.*/
    private double ytdT;


    /** Constructor for class PayStub.*/
    public PayStub(String name, double netPay, double tax, double ytdE, double ytdT) {
        this.name = name;
        this.netPay = netPay;
        this.tax = tax;
        this.ytdE = ytdE;
        this.ytdT = ytdT;
    }

    /**
     * Gets the employee's name.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the pay for the current pay period.
     *
     * @return the pay for the current pay period
     */
    @Override
    public double getPay() {
        return netPay;
    }

    /**
     * Gets the taxes paid for the current pay period.
     *
     * @return the taxes paid for the current pay period
     */
    @Override
    public double getTaxesPaid() {
        return tax;
    }

    /**
     * Gets the YTD earnings of the employee.
     *
     * @return the YTD earnings of the employee
     */
    public double getYtdE() {
        return ytdE;
    }

    /**
     * Gets the taxes paid for the current pay period.
     *
     * @return the taxes paid for the current pay period
     */
    public double getYtdT() {
        return ytdT;
    }

    /**
     * Converts the paystub to a CSV string.
     *
     * @return the paystub as a CSV string
     */
    @Override
    public String toCSV() {
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                name, netPay, tax, ytdE, ytdT);
    }
}
