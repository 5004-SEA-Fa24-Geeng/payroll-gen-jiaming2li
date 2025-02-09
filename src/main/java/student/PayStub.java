package student;

/**
 * Represents a pay stub for an employee, detailing their earnings, deductions, and taxes for a pay period.
 * This class stores essential payroll information and provides methods for retrieving formatted details.
 */
public class PayStub implements IPayStub {
    /** taxes paid for the current pay period.*/
    private double tax;

    /** the name of the employee.*/
    private String name;

    /** net pay for the current pay period.*/
    private double netPay;

    /** year-to-date (YTD) earnings.*/
    private double ytdE;

    /** year-to-date (YTD) taxes paid.*/
    private double ytdT;


    /** Constructor for class PayStub.
     *
     * @param name name of the employee.
     * @param netPay net pay for the current pay period.
     * @param tax tax for the current pay period.
     * @param ytdE year-to-date (YTD) total earnings of the employee.
     * @param ytdT year-to-date (YTD) total taxes paid by the employee.
     */
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
     * Gets the net pay for the current pay period.
     *
     * @return the net pay for the current pay period
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
     * Converts the pay stub to a CSV string.
     *
     * @return the pay stub as a CSV string
     */
    @Override
    public String toCSV() {
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                name, netPay, tax, ytdE, ytdT);
    }
}
