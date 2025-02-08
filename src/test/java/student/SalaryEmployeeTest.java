package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {
    private SalaryEmployee e1;
    private SalaryEmployee e2;

    @BeforeEach
    void setUp() {
        e1 = new SalaryEmployee("Nami", "s193", 200000, 17017, 4983, 1000);
        e2 = new SalaryEmployee("Edward Elric", "f103", 100000, 11000, 2333, 250);
        assertTrue(e1 instanceof SalaryEmployee);
        assertTrue(e2 instanceof SalaryEmployee);
    }



    @Test
    void getName() {
        assertEquals("Nami", e1.getName());
        assertEquals("Edward Elric", e2.getName());
    }

    @Test
    void getID() {
        assertEquals("s193", e1.getID());
        assertEquals("f103", e2.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(200000, e1.getPayRate());
        assertEquals(100000, e2.getPayRate());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(17017, e1.getYTDEarnings());
        assertEquals(11000, e2.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(4983, e1.getYTDTaxesPaid());
        assertEquals(2333, e2.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(1000, e1.getPretaxDeductions());
        assertEquals(250, e2.getPretaxDeductions());
    }

    @Test
    void getEmployeeType() {
        assertEquals("SALARY", e1.getEmployeeType());
        assertEquals("SALARY", e2.getEmployeeType());
    }

    @Test
    void runPayroll() {
        String expectedCsv1 = "Nami,5672.33,1661.00,22689.33,6644.00";
        assertEquals(expectedCsv1, e1.runPayroll(60).toCSV());
        String expectedCsv2 = "Edward Elric,3029.54,887.13,14029.54,3220.13";
        assertEquals(expectedCsv2, e2.runPayroll(30).toCSV());
        //SALARY,Nami,s193,200000.0,1000.0,22689.33,6644.0
    }

    @Test
    void toCSV() {
        assertEquals("SALARY,Nami,s193,200000.0,1000.0,17017.0,4983.0", e1.toCSV());
        assertEquals("SALARY,Edward Elric,f103,100000.0,250.0,11000.0,2333.0", e2.toCSV());
    }
}