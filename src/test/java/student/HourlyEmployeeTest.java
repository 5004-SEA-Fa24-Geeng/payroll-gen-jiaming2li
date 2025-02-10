package student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class HourlyEmployeeTest {
    private HourlyEmployee e1;
    private HourlyEmployee e2;
    private HourlyEmployee e3;



    @BeforeEach
    void setUp() {
        e1 = new HourlyEmployee("Luffy", "s192", 30.00, 20000.00, 4530, 0);
        assertTrue(e1 instanceof HourlyEmployee);
        e2 = new HourlyEmployee("Light Yagami", "x101", 25.00, 10000.00, 2265, 0);
        assertTrue(e2 instanceof HourlyEmployee);
        e3 = new HourlyEmployee("Eren Yeager", "a105", 35.00, 6000.00, 1359, 0);
        assertTrue(e3 instanceof HourlyEmployee);
    }

    @Test
    void getName() {
        assertEquals("Luffy", e1.getName());
        assertEquals("Light Yagami", e2.getName());
    }

    @Test
    void getID() {
        assertEquals("s192", e1.getID());
        assertEquals("x101", e2.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(30.00, e1.getPayRate());
        assertEquals(25.00, e2.getPayRate());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(20000.00, e1.getYTDEarnings());
        assertEquals(10000.00, e2.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(4530.00, e1.getYTDTaxesPaid());
        assertEquals(2265.00, e2.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(0, e1.getPretaxDeductions());
        assertEquals(0, e2.getPretaxDeductions());
    }

    @Test
    void getEmployeeType() {
        assertEquals("HOURLY", e1.getEmployeeType());
        assertEquals("HOURLY", e2.getEmployeeType());
    }

    @Test
    void runPayroll() {
        String expectedCsv1 = "Luffy,1102.24,322.76,21102.24,4852.76";
        assertEquals(expectedCsv1, e1.runPayroll(45).toCSV());
        String expectedCsv2 = "Light Yagami,773.50,226.50,10773.50,2491.50";
        assertEquals(expectedCsv2, e2.runPayroll(40).toCSV());
        assertEquals(null, e3.runPayroll(-5));
    }

    @Test
    void toCSV() {
        assertEquals("HOURLY,Luffy,s192,30.0,0.0,20000.0,4530.0", e1.toCSV());
        assertEquals("HOURLY,Light Yagami,x101,25.0,0.0,10000.0,2265.0", e2.toCSV());

    }
}