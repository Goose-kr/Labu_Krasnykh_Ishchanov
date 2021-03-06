package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdentityFunctionTest {
    private final MathFunction identity = new IdentityFunction();

    @Test
    public void testApply() {
        assertEquals(identity.apply(5), 5, 0.00001);
        assertEquals(identity.apply(9), 9, 0.00001);
        assertEquals(identity.apply(7), 7, 0.00001);
    }

}