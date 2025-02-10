package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a salary employee, storing details such as pay rate, work hours, and earnings.
 * This class manages payroll-related calculations for hourly employees.
 */
public class SalaryEmployee implements IEmployee {
    /** Employee's name. */
    private String name;

    /** employee ID. */
    private String id;

    /** Pay rate (hourly wage or annual salary). */
    private double payRate;

    /** Year-to-date (YTD) earnings. */
    private double ytdEarnings;

    /** Year-to-date (YTD) taxes paid. */
    private double ytdTaxesPaid;

    /** Pre-tax deductions. */
    private double pretaxDeductions;

    /** Constructor for class salary employee.
     * @param name name of the employee.
     * @param id ID of the employee.
     * @param payRate pay rate of the employee.
     * @param ytdEarnings year-to-date (YTD) total earnings of the employee.
     * @param ytdTaxesPaid year-to-date (YTD) total taxes paid by the employee.
     * @param pretaxDeductions total pre-tax deductions.
     */
    public SalaryEmployee(String name, String id, double payRate,
                          double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions
    ) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    /**
     * Gets the employee's name.
     *
     * @return the name of the employee
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the employee's ID.
     *
     * @return the ID of the employee
     */
    @Override
    public String getID() {
        return id;
    }

    /**
     * Gets the employee's pay rate.
     *
     * @return the pay rate of the employee
     */
    @Override
    public double getPayRate() {
        return payRate;
    }

    /**
     * Gets the YTD earnings of the employee.
     *
     * @return the YTD earnings of the employee
     */
    @Override
    public double getYTDEarnings() {
        return ytdEarnings;
    }

    /**
     * Gets the YTD taxes paid by the employee.
     *
     * @return the YTD taxes paid by the employee
     */
    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }

    /**
     * Gets pretax deductions for the employee.
     *
     * @return the pretax deductions for the employee
     */
    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }

    /**
     * Gets the employee's Type as a string.
     * Either "HOURLY" or "SALARY" depending on the type of employee.
     *
     * @return the type of the employee as a string
     */
    @Override
    public String getEmployeeType() {
        return "SALARY";
    }

    /**
     * This will calculate the pay for the current pay, update the YTD earnings, and update the
     * taxes paid YTD.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return the pay stub for the current pay period
     */
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }

        BigDecimal pDeductions = new BigDecimal(pretaxDeductions);


        BigDecimal pay = new BigDecimal(payRate).divide(new BigDecimal(24), 2, RoundingMode.HALF_UP);
        BigDecimal TaxesBD = (pay.subtract(pDeductions)).multiply(new BigDecimal(0.2265));
        BigDecimal netPayBD = pay.subtract(TaxesBD).subtract(pDeductions);


        ytdEarnings = new BigDecimal(ytdEarnings).add(netPayBD).doubleValue();
        ytdTaxesPaid = new BigDecimal(ytdTaxesPaid).add(TaxesBD).doubleValue();
        double taxes = TaxesBD.doubleValue();
        double netPay = netPayBD.doubleValue();

        return new PayStub(name, netPay, taxes, ytdEarnings, ytdTaxesPaid);
    }

    /**
     * Converts the employee to a CSV string.
     *
     * @return the employee as a CSV string
     */
    @Override
    public String toCSV() {
        return getEmployeeType() + ","
                + name + ","
                + id + ","
                + payRate + ","
                + pretaxDeductions + ","
                + ytdEarnings + ","
                + ytdTaxesPaid;
    }
}
