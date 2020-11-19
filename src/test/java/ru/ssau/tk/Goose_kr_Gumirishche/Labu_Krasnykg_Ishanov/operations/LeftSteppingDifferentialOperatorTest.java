package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.SqrFunction;

import static org.testng.Assert.*;

public class LeftSteppingDifferentialOperatorTest {

    @Test
    public void testDerive() {
        SteppingDifferentialOperator left = new LeftSteppingDifferentialOperator(3);
        assertEquals(left.derive(new SqrFunction()).apply(12), 21, 0.000001);
        assertEquals(left.derive(new SqrFunction()).apply(16), 29, 0.00001);
        left.step = 6;
        assertEquals(left.derive(new SqrFunction()).apply(16), 26, 0.00001);
    }
}