package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnitFunctionTest {
    private final MathFunction unit = new UnitFunction();

    @Test
    public void testUnit() {
        assertEquals(unit.apply(7), 1, 0.000001);
        assertEquals(unit.apply(34637642),1,0.00000001);
        assertEquals(unit.apply(-347523762),1,0.000001);
    }
}