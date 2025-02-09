package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {
    Builder b1;
    Builder b2;
    Builder b3;
    Builder b4;

    @BeforeEach
    void setUp() {
    }

    @Test
    void buildEmployeeFromCSV() {
        assertEquals("HOURLY,Luffy,s192,30.0,0.0,20000.0,4530.0",b1.buildEmployeeFromCSV("HOURLY,Luffy,s192,30.00,0,20000,4530").toCSV());
        assertEquals("SALARY,Nami,s193,200000.0,1000.0,17017.0,4983.0",b1.buildEmployeeFromCSV("SALARY,Nami,s193,200000,1000,17017,4983").toCSV());
        assertEquals(null, b3.buildEmployeeFromCSV("HOURLY,Eren Yeager,a105,35.00,0"));
        assertEquals(null, b4.buildEmployeeFromCSV("SALARY,Spike Spiegel,c107,180000,SALARY,15000,3500"));
    }

    @Test
    void buildTimeCardFromCSV() {
        assertEquals("TimeCard{employeeID='s192', hoursWorked=45.0}",b1.buildTimeCardFromCSV("s192,45").toString());
        assertEquals("TimeCard{employeeID='s193', hoursWorked=60.0}",b2.buildTimeCardFromCSV("s193,60").toString());
        assertEquals(null, b3.buildTimeCardFromCSV("s193"));
        assertEquals(null, b4.buildTimeCardFromCSV("a105,a105"));
    }
}