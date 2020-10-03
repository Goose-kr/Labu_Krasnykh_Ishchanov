package functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SqrFunctionTest {
    public MathFunction sqr = new SqrFunction();

    @Test
    public void testSqr() {
        assertEquals(sqr.apply(5), 25, 0.00001);
        assertEquals(sqr.apply(-6),36,0.0001);
        assertEquals(sqr.apply(-8),64,0.000001);
    }
}