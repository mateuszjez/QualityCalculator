package pl.edu.agh.qualitycalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculationsVerbalizerTest {
    private CalculationsVerbalizer calculationsVerbalizerUnderTest;
    @Before
    public void setUp() {
        calculationsVerbalizerUnderTest = new CalculationsVerbalizer();
    }

    @Test
    public void verbalize() throws Exception {
        assertEquals("1.0 plus 2.0 gives value 3.0",calculationsVerbalizerUnderTest.verbalize(Operation.SUM,1,2,3));
        assertEquals("1.0 minus 2.0 gives value -1.0",calculationsVerbalizerUnderTest.verbalize(Operation.SUBTRACT,1,2,-1));
        assertEquals("1.0 multiplied by 2.0 gives value 2.0",calculationsVerbalizerUnderTest.verbalize(Operation.MULTIPLY,1,2,2));
        assertEquals("1.0 divided by 2.0 gives value 0.5",calculationsVerbalizerUnderTest.verbalize(Operation.DIVIDE,1,2,(float)0.5));
    }

    @After
    public void tearDown() {
    }
}
