package functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnitFunctionTest {
    private  final MathFunction unit= new UnitFunction();
    @Test
    public void testUnit(){
        assertEquals(unit.apply(7),1,0.000001);
    }
}