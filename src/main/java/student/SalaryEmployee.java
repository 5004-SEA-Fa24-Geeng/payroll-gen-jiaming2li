package student;

public class SalaryEmployee implements IEmployee{
    private String name;
    private String id;
    private double payRate;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double pretaxDeductions;
    private double h_pay;
    private double h_taxes;

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

    public double getYTDTaxesPaid(){
        return ytdTaxesPaid;
    }

    public double getPretaxDeductions(){
        return pretaxDeductions;
    }

    public String getEmployeeType(){
        return "SALARY";
    }

    public IPayStub runPayroll(double hoursWorked){

        h_pay = getPayRate()/24;
        h_taxes = (h_pay - getPretaxDeductions())* 0.2265;
        return new PayStub(h_pay, h_taxes,this);
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                getEmployeeType(), getName(), getID(), getPayRate(), getPretaxDeductions(), getYTDEarnings()+h_pay-h_taxes-getPretaxDeductions(), getYTDTaxesPaid()+h_taxes);

    }
}
