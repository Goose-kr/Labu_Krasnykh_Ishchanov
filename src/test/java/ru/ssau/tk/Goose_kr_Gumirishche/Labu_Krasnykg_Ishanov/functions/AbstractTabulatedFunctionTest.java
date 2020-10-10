package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbstractTabulatedFunctionTest {
    private final static double ACCURACY = 0.00000001;
    MockTabulatedFunction mock = new MockTabulatedFunction();

    @Test
    public  void testApply(){
    assertEquals(mock.apply(4.0),3,ACCURACY);
    assertEquals(mock.apply(5.0),4,ACCURACY);
    assertEquals(mock.apply(7.0),6,ACCURACY);
        assertEquals(mock.apply(7),6,ACCURACY);
    }

}