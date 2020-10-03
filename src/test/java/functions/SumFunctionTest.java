package functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SumFunctionTest {
    public MathFunction sum = new SumFunction();

    @Test
    public void testSum() {
        assertEquals(sum.apply(5), 10, 0.0000001);
        assertEquals(sum.apply(-5), -10, 0.00001);
        assertEquals(sum.apply(-3552), -7104, 0.00001);
    }
}