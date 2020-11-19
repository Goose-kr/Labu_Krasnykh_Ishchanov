package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.SqrFunction;

import static org.testng.Assert.*;

public class RightSteppingDifferentialOperatorTest {

    @Test
    public void testDerive() {
        SteppingDifferentialOperator right = new RightSteppingDifferentialOperator(3);
        assertEquals(right.derive(new SqrFunction()).apply(12), 27, 0.000001);
        assertEquals(right.derive(new SqrFunction()).apply(16), 35, 0.00001);
        right.step = 6;
        assertEquals(right.derive(new SqrFunction()).apply(16), 38, 0.00001);
    }
}