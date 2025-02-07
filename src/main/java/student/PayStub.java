package student;

public class PayStub implements IPayStub{
    double hoursWorked;
    double pay;
    double tax;
    IEmployee e;


    public PayStub(double pay, double tax, IEmployee e) {
        this.pay = pay;
        this.tax = tax;
        this.e = e;
    }

    @Override
    public double getPay(){
        return pay;
    }

    @Override
    public double getTaxesPaid(){
        return tax;
    }

    @Override
    public String toCSV(){
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                e.getName(), pay-tax-e.getPretaxDeductions(), tax, e.getYTDEarnings(), e.getYTDTaxesPaid());
    }
}
