package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void toCSV() {
        HourlyEmployee e = new HourlyEmployee("Luffy", "s192", 30.00, 20000.00, 4530.00, 0.00);
        assertEquals("HOURLY, Luffy, s192, 30.00, 20000.00, 4530.00, 0.00",e.toCSV());
    }
}