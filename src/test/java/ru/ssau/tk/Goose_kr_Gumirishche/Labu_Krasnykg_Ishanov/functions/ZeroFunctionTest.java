package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ZeroFunctionTest {
    private final MathFunction zero = new ZeroFunction();

    @Test
    public void testZero() {
        assertEquals(zero.apply(1), 0, 0.0001);
        assertEquals(zero.apply(2362468), 0, 0.0000001);
        assertEquals(zero.apply(-368734638), 0, 0.000001);
    }

}