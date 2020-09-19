package functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MultiplyFunctionTest {
    public MathFunction multiply = new MultiplyFunction();
    @Test
    public void applyTest (){
        assertEquals(multiply.apply(5),25,0.000001);
    }
}