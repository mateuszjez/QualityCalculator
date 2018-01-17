package pl.edu.agh.qualitycalculator;

import junit.framework.Assert;

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
    @Test
    public void testDivideByZero() throws Exception {
        try {
            calculationsUnderTest.calculate(Operation.DIVIDE, 9, 0);
            Assert.fail("Division by zero");
        }
        catch(Exception ex) {
            //success :)
        }
    }
    @Test
    public void testUnknownOperation1() throws Exception {
        try{
            calculationsUnderTest.calculate(null,1,2);
            Assert.fail("Unknown operation");
        }
        catch(Exception ex){
            //success
        }
    }
    @Test
    public void testUnknownOperation2() throws Exception {
        try{
            calculationsUnderTest.calculate(null,1,2,3);
            Assert.fail("Unknown operation");
        }
        catch(Exception ex){
            //success
        }
    }

    @After
    public void tearDown() {
    }
}
