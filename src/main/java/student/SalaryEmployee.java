package student;

public class SalaryEmployee implements IEmployee{
    private String name;
    private String id;
    private double payRate;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double pretaxDeductions;


    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
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
        return "SALARY";
    }

    @Override
    public IPayStub runPayroll(double hoursWorked){
        if (hoursWorked < 0) {
            return null;
        }

        double h_pay = payRate/24;
        double h_taxes = (h_pay - pretaxDeductions)* 0.2265;
        double net_pay = h_pay-h_taxes-pretaxDeductions;
        ytdEarnings += net_pay;
        ytdTaxesPaid += h_taxes;

        return new PayStub(name,net_pay, h_taxes, ytdEarnings, ytdTaxesPaid);
        //return new PayStub(h_pay, h_taxes,this);
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
