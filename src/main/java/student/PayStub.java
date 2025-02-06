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

    public double getPay(){
        return pay;
    }

    public double getTaxesPaid(){
        return tax;
    }

    public String toCSV(){
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                e.getName(), pay-tax-e.getPretaxDeductions(), tax, e.getYTDEarnings()+pay-tax-e.getPretaxDeductions(), e.getYTDTaxesPaid()+tax);
    }
}
