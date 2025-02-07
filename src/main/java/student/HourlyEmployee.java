package student;

public class HourlyEmployee implements IEmployee{
    private String name;
    private String id;
    private double payRate;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double pretaxDeductions;
    private double h_pay;
    private double h_taxes;
    private double net_pay;

    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    @Override
    public String getName(){
        return name;
        }

    @Override
    public String getID(){
        return id;
    }

    @Override
    public double getPayRate(){
        return payRate;
    }


    @Override
    public double getYTDEarnings(){
        return ytdEarnings;
    }

    @Override
    public double getYTDTaxesPaid(){
        return ytdTaxesPaid;
    }

    @Override
    public double getPretaxDeductions(){
        return pretaxDeductions;
    }

    @Override
    public String getEmployeeType(){
        return "HOURLY";
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }

        double totalPay = payRate * hoursWorked;
        if (hoursWorked > 40) {
            totalPay += (hoursWorked - 40) * (payRate * 0.5);
        }

        double payShouldTax = totalPay - pretaxDeductions;
        double taxes = payShouldTax * 0.2265;
        double payAfterTax = payShouldTax - taxes;
        ytdEarnings += payAfterTax;
        ytdTaxesPaid += taxes;

        return new PayStub(name, payAfterTax, taxes, ytdEarnings, ytdTaxesPaid);
    }

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
