package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCardTest {
    private TimeCard c1;
    private TimeCard c2;

    @BeforeEach
    void setUp() {
        c1 = new TimeCard("s192", 45);
        c2 = new TimeCard("s193", 60);
        assertTrue(c1 instanceof TimeCard);
        assertTrue(c2 instanceof TimeCard);
    }

    @Test
    void getEmployeeID() {
        assertEquals("s192", c1.getEmployeeID());
        assertEquals("s193", c2.getEmployeeID());
    }

    @Test
    void getHoursWorked() {
        assertEquals(45, c1.getHoursWorked());
        assertEquals(60, c2.getHoursWorked());
    }

    @Test
    void testToString() {
        assertEquals("TimeCard{employeeID='s192', hoursWorked=45.0}", c1.toString());
        assertEquals("TimeCard{employeeID='s193', hoursWorked=60.0}", c2.toString());
    }
}