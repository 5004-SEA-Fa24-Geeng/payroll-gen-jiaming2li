package student;

public class SalaryEmployee implements IEmployee{
    /** Employee's name */
    private String name;

    /** employee ID */
    private String id;

    /** Pay rate (hourly wage or annual salary) */
    private double payRate;

    /** Year-to-date (YTD) earnings */
    private double ytdEarnings;

    /** Year-to-date (YTD) taxes paid */
    private double ytdTaxesPaid;

    /** Pre-tax deductions */
    private double pretaxDeductions;


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
    public String getName(){
        return name;
    }

    /**
     * Gets the employee's ID.
     *
     * @return the ID of the employee
     */
    @Override
    public String getID(){
        return id;
    }

    /**
     * Gets the employee's pay rate.
     *
     * @return the pay rate of the employee
     */
    @Override
    public double getPayRate(){
        return payRate;
    }

    /**
     * Gets the YTD earnings of the employee.
     *
     * @return the YTD earnings of the employee
     */
    @Override
    public double getYTDEarnings(){
        return ytdEarnings;
    }

    /**
     * Gets the YTD taxes paid by the employee.
     *
     * @return the YTD taxes paid by the employee
     */
    @Override
    public double getYTDTaxesPaid(){
        return ytdTaxesPaid;
    }

    /**
     * Gets pretax deductions for the employee.
     *
     * @return the pretax deductions for the employee
     */
    @Override
    public double getPretaxDeductions(){
        return pretaxDeductions;
    }

    /**
     * Gets the employee's Type as a string.
     * Either "HOURLY" or "SALARY" depending on the type of employee.
     *
     * @return the type of the employee as a string
     */
    @Override
    public String getEmployeeType(){
        return "SALARY";
    }

    /**
     * This will calculate the pay for the current pay, update the YTD earnings, and update the
     * taxes paid YTD.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return the pay stub for the current pay period
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }

        double hPay = payRate / 24;
        double hTaxes = (hPay - pretaxDeductions) * 0.2265;
        double netPay = hPay - hTaxes - pretaxDeductions;
        ytdEarnings += netPay;
        ytdTaxesPaid += hTaxes;

        return new PayStub(name, netPay, hTaxes, ytdEarnings, ytdTaxesPaid);
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
