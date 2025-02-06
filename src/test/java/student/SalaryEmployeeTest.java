package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {
    private SalaryEmployee s;

    @BeforeEach
    void setUp() {
    }

    @Test
    void toCSV() {
        s = new SalaryEmployee("John Doe", "12345", 100000,1000.00,  100.00, 1000);
        assertEquals("SALARY,John Doe,12345,100000,1000,100,1000", s.toCSV());
    }
}