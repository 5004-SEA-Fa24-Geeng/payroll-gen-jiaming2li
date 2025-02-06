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
        return this.ytdEarnings;
    }

    public double getYTDTaxesPaid(){
        return this.ytdTaxesPaid;
    }

    public double getPretaxDeductions(){
        return pretaxDeductions;
    }

    public String getEmployeeType(){
        return "HOURLY";
    }

    public void setYtdEarnings(double n){
        ytdEarnings = n;
    }

    public void setYtdTaxesPaid(double n){
        ytdTaxesPaid = n;
    }

    public IPayStub runPayroll(double hoursWorked){
        if (hoursWorked > 40) {
            h_pay = 1.5 * getPayRate() * (hoursWorked - 40) + 40 * getPayRate();
        } else {
            h_pay = hoursWorked * getPayRate();
        }
        h_taxes = (h_pay - getPretaxDeductions())* 0.2265;
        //setYtdEarnings(ytdEarnings - h_taxes + h_pay - pretaxDeductions);
        //setYtdTaxesPaid(ytdTaxesPaid + h_taxes);
        ytdEarnings += h_pay-h_taxes-pretaxDeductions;
        ytdTaxesPaid += h_taxes;
        return new PayStub(h_pay, h_taxes,this);
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                getEmployeeType(), getName(), getID(), getPayRate(), getPretaxDeductions(), getYTDEarnings(), getYTDTaxesPaid());

    }
}
