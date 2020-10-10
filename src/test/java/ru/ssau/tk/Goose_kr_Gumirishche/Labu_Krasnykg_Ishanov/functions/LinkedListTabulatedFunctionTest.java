package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {
    protected final double[] xValues1=new double[]{-2,-1,0,1,2};
    protected final double[] yValues1=new double[]{4,1,0,1,4};
    protected final double[] xValues2=new double[]{-4,-3,-2,-1,0,1,2,3,4};
    protected final double[] yValues2=new double[]{16,9,4,1,0,1,4,9,16};

    LinkedListTabulatedFunction linkedListTabulatedFunction1=new LinkedListTabulatedFunction(xValues1,yValues1);
    LinkedListTabulatedFunction linkedListTabulatedFunction2 = new LinkedListTabulatedFunction(xValues2,yValues2);
    CompositeFunction compositeFunction = new CompositeFunction(new SumFunction(),new SqrFunction());
    LinkedListTabulatedFunction linkedListTabulatedFunction3 = new LinkedListTabulatedFunction(compositeFunction,-3,3,7);

    @Test
    public void testCount(){
        assertEquals(linkedListTabulatedFunction1.getCount(),5,0.00001);
        assertEquals(linkedListTabulatedFunction2.getCount(),9,0.00001);
        assertEquals(linkedListTabulatedFunction3.getCount(),7,0.0001);
    }

}