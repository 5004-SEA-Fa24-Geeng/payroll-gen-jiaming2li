package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayStubTest {
    PayStub p1;
    PayStub p2;


    @BeforeEach
    void setUp() {
        p1 = new PayStub("Luffy",1102.24,322.76,21102.24,4852.76);
        p2 = new PayStub("Nami",5672.33,1661.00,22689.33,6644.00);
        assertTrue(p1 instanceof PayStub);
        assertTrue(p2 instanceof PayStub);
    }

    @Test
    void getPay() {
        assertEquals(1102.24,p1.getPay());
        assertEquals(5672.33,p2.getPay());
    }

    @Test
    void getTaxesPaid() {
        assertEquals(322.76,p1.getTaxesPaid());
        assertEquals(1661.0,p2.getTaxesPaid());
    }

    @Test
    void toCSV() {
        assertEquals("Luffy,1102.24,322.76,21102.24,4852.76",p1.toCSV());
        assertEquals("Nami,5672.33,1661.00,22689.33,6644.00",p2.toCSV());
    }
}