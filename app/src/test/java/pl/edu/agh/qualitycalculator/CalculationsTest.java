package pl.edu.agh.qualitycalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculationsTest {
    Calculations calculationsUnderTest;

    @Before
    public void setUp() {
        calculationsUnderTest = new Calculations();
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(5, calculationsUnderTest.calculate(Operation.SUM, 2, 3), 0.01);
    }
    @Test
    public void testSubtract() throws Exception {
        assertEquals(2, calculationsUnderTest.calculate(Operation.SUBTRACT, 6, 4), 0.01);
    }
    @Test
    public void testMultiply() throws Exception {
        assertEquals(6, calculationsUnderTest.calculate(Operation.MULTIPLY, 2, 3), 0.01);
    }
    @Test
    public void testDivide() throws Exception {
        assertEquals(3, calculationsUnderTest.calculate(Operation.DIVIDE, 9, 3), 0.01);
    }
    @Test
    public void testAverage() throws Exception {
        assertEquals(5, calculationsUnderTest.calculate(Operation.AVERAGE, 2, 6, 7), 0.01);
    }
//    @Test
//    public void testDivideByZero() throws Exception {
//        try {
//            calculationsUnderTest.calculate(Operation.DIVIDE, 9, 0);
//        }
//        catch(Exception ex) {
//            assertEquals(new Exception("Division by zero"),ex.toString());
//        }
//    }

    @After
    public void tearDown() {
    }
}
