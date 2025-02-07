package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HourlyEmployeeTest {
    private HourlyEmployee e;

    @BeforeEach
    public void setUp() {
        e = new HourlyEmployee("John Doe", "s192", 20.00, 10000.00, 2000.00, 500.00);
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", e.getName());
    }

    @Test
    public void testGetID() {
        assertEquals("s192", e.getID());
    }

    @Test
    public void testGetPayRate() {
        assertEquals(20.00, e.getPayRate());
    }

    @Test
    public void testGetYTDEarnings() {
        assertEquals(10000.00, e.getYTDEarnings());
    }

    @Test
    public void testGetYTDTaxesPaid() {
        assertEquals(2000.00, e.getYTDTaxesPaid());
    }

    @Test
    public void testGetPretaxDeductions() {
        assertEquals(500.00, e.getPretaxDeductions());
    }

    @Test
    public void testRunPayrollWithLessThan40Hours() {

        IPayStub payStub = e.runPayroll(30);
        assertEquals(600.00, payStub.getPay());
        assertEquals(135.00, payStub.getTaxes(), "The tax should be 135.00 (600 * 0.2265 - pretaxDeductions)");
    }

    @Test
    public void testRunPayrollWithMoreThan40Hours() {
        // Test with 45 hours worked
        IPayStub payStub = e.runPayroll(45);
        assertNotNull(payStub, "The pay stub should not be null");
        assertEquals(950.00, payStub.getPay(), "The pay should be 950.00 (40 hours * 20 + 5 hours * 1.5 * 20)");
        assertEquals(214.10, payStub.getTaxes(), "The tax should be 214.10 (950 * 0.2265 - pretaxDeductions)");
    }

    @Test
    public void testToCSV() {
        String expectedCSV = "HOURLY,John Doe,s192,20.00,500.00,10000.00,2000.00";
        assertEquals(expectedCSV, e.toCSV());
    }

    @Test
    public void testEmployeeType() {
        assertEquals("HOURLY", e.getEmployeeType());
    }
}
