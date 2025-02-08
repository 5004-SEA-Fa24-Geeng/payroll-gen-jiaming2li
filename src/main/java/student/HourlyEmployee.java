package student;

/**
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public class HourlyEmployee implements IEmployee{
    private String name;
    private String id;
    private double payRate;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double pretaxDeductions;


    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
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
        return "HOURLY";
    }

    /**
     * This will calculate the pay for the current pay, update the YTD earnings, and update the
     * taxes paid YTD.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return the pay stub for the current pay period
     */
    @Override
    public IPayStub runPayroll(double hoursWorked){

        if (hoursWorked < 0) {
            return null;
        }

        double h_pay = hoursWorked * payRate;
        if (hoursWorked > 40) {
            h_pay += (hoursWorked-40)*0.5 * payRate;
        };

        double h_taxes = (h_pay - pretaxDeductions)* 0.2265;
        double net_pay = h_pay-h_taxes-pretaxDeductions;
        ytdEarnings += net_pay;
        ytdTaxesPaid += h_taxes;

        return new PayStub(name, net_pay,h_taxes,ytdEarnings,ytdTaxesPaid);
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
