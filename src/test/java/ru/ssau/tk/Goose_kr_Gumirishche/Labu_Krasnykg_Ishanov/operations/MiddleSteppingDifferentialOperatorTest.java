package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.SqrFunction;

import static org.testng.Assert.*;

public class MiddleSteppingDifferentialOperatorTest {

    @Test
    public void testDerive() {
        SteppingDifferentialOperator middle = new MiddleSteppingDifferentialOperator(3);
        assertEquals(middle.derive(new SqrFunction()).apply(12), 24, 0.000001);
        assertEquals(middle.derive(new SqrFunction()).apply(16), 32, 0.00001);
        middle.step = 6;
        assertEquals(middle.derive(new SqrFunction()).apply(16), 32, 0.00001);
    }
}