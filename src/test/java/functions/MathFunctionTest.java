package functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MathFunctionTest {
    private final MathFunction sqr = new SqrFunction();
    private final MathFunction sum = new SumFunction();
    private final MathFunction composite = sqr.andThen(sum);
    private final MathFunction composite1 = sum.andThen(sqr);

    @Test
    public void andThen() {
        assertEquals(composite.apply(5), 50, 0.00001);
        assertEquals(composite1.apply(5),100,0.000001);
        assertEquals(composite1.apply(-4),64,0.00001);
    }


}