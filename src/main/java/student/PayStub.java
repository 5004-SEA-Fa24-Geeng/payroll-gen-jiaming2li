package student;

public class PayStub implements IPayStub{
    //double hoursWorked;
    double tax;
    String name;
    double Npay;
    double ytdE;
    double ytdT;

    //IEmployee e;


    public PayStub(String name, double Npay, double tax, double ytdE, double ytdT) {
        this.name = name;
        this.Npay = Npay;
        this.tax = tax;
        this.ytdE = ytdE;
        this.ytdT = ytdT;
        //this.e = e;
    }

    @Override
    public double getPay(){
        return Npay;
    }

    @Override
    public double getTaxesPaid(){
        return tax;
    }

    @Override
    public String toCSV(){
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                name, Npay, tax, ytdE, ytdT);
    }
}
