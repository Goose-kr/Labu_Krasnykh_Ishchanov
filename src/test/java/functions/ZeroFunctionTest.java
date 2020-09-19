package functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ZeroFunctionTest {
    private final MathFunction zero=new ZeroFunction();
    @Test
    public void testZero(){
        assertEquals(zero.apply(1),0,0.0001);
    }

}