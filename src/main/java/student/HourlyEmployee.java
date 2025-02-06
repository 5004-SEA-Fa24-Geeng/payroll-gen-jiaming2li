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

    public double getYTDTaxesPaid(){
        return ytdTaxesPaid;
    }

    public double getPretaxDeductions(){
        return pretaxDeductions;
    }

    public String getEmployeeType(){
        return "Hourly";
    }

    public IPayStub runPayroll(double hoursWorked){
        if (hoursWorked > 40) {
            h_pay = 1.5 * getPayRate() * (hoursWorked - 40) + 40 * getPayRate();
        } else {
            h_pay = hoursWorked * getPayRate();
        }
        h_taxes = (h_pay - getPretaxDeductions())* 0.2265;
        return new PayStub(h_pay, h_taxes,this);
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                getEmployeeType(), getName(), getID(), getPayRate(), getPretaxDeductions(), getYTDEarnings()+h_pay-h_taxes-getPretaxDeductions(), getYTDTaxesPaid()+h_taxes);

    }
}
