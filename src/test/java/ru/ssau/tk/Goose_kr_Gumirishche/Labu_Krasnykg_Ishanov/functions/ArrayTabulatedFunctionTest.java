package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionTest {
    protected final double[] xValues1=new double[]{-2,-1,0,1,2};
    protected final double[] yValues1=new double[]{4,1,0,1,4};
    protected final double[] xValues2=new double[]{-4,-3,-2,-1,0,1,2,3,4};
    protected final double[] yValues2=new double[]{16,9,4,1,0,1,4,9,16};
    ArrayTabulatedFunction arrayTabulatedFunction1=new ArrayTabulatedFunction(xValues1,yValues1);
    ArrayTabulatedFunction arrayTabulatedFunction2=new ArrayTabulatedFunction(xValues2,yValues2);
    @Test
    public void testCount(){
    assertEquals(arrayTabulatedFunction1.getCount(),5,0.00001);
    assertEquals(arrayTabulatedFunction2.getCount(),9,0.00001);
    }
    @Test
    public void testGetX(){
        assertEquals(arrayTabulatedFunction1.getX(0),-2,0.000001);
        assertEquals(arrayTabulatedFunction1.getX(4),2,0.0001);
        assertEquals(arrayTabulatedFunction2.getX(4),0,0.000001);
    }
    @Test
    public void testGetY(){
        assertEquals(arrayTabulatedFunction1.getY(0),4,0.000001);
        assertEquals(arrayTabulatedFunction1.getY(4),4,0.0001);
        assertEquals(arrayTabulatedFunction2.getY(4),0,0.000001);
    }
    @Test
    public void testSetY(){
        arrayTabulatedFunction1.setY(0,16);
        arrayTabulatedFunction1.setY(4,18);
        arrayTabulatedFunction2.setY(4,-20);
        assertEquals(arrayTabulatedFunction1.getY(0),16,0.000001);
        assertEquals(arrayTabulatedFunction1.getY(4),18,0.0001);
        assertEquals(arrayTabulatedFunction2.getY(4),-20,0.000001);
    }
    @Test
    public void testIndexOfX(){
        assertEquals(arrayTabulatedFunction1.indexOfX(-1),1,0.00001);
        assertEquals(arrayTabulatedFunction1.indexOfX(10),-1,0.00001);
        assertEquals(arrayTabulatedFunction2.indexOfX(3),7,0.00001);
    }
    @Test
    public void testIndexOfY(){
        assertEquals(arrayTabulatedFunction2.indexOfY(16),0,0.00001);
        assertEquals(arrayTabulatedFunction2.indexOfY(436436),-1,0.00001);
        assertEquals(arrayTabulatedFunction1.indexOfY(4),0,0.0001);
    }
    @Test
    public void testLeftBound(){
        assertEquals(arrayTabulatedFunction1.leftBound(),-2,0.00001);
        assertEquals(arrayTabulatedFunction2.leftBound(),-4,0.00001);
    }
    @Test
    public void testRightBound(){
        assertEquals(arrayTabulatedFunction1.rightBound(),2,0.00001);
        assertEquals(arrayTabulatedFunction2.rightBound(),4,0.00001);
    }
    @Test
    public void testFloorIndexOfX(){
        assertEquals(arrayTabulatedFunction2.floorIndexOfX(-3.5),0,0.00001);
        assertEquals(arrayTabulatedFunction2.floorIndexOfX(-0.1421),3,0.00001);
        assertEquals(arrayTabulatedFunction1.floorIndexOfX(-10),0,0.00001);
    }
    @Test
    public void testExtrapolateLeft(){
        assertEquals(arrayTabulatedFunction2.extrapolateLeft(5),-47,0.00001);
        assertEquals(arrayTabulatedFunction2.extrapolateLeft(17),-131,0.000001);
        assertEquals(arrayTabulatedFunction2.extrapolateLeft(-16),100,0.00001);
    }
    @Test
    public  void testExtrapolateRight(){
        assertEquals(arrayTabulatedFunction2.extrapolateRight(5),23,0.00001);
        assertEquals(arrayTabulatedFunction2.extrapolateRight(15),93,0.000001);
        assertEquals(arrayTabulatedFunction2.extrapolateRight(-20),-152,0.00001);
    }
    @Test
    public void testInterpolate(){
        assertEquals(arrayTabulatedFunction2.interpolate(16,2),40,0.000001);
        assertEquals(arrayTabulatedFunction2.interpolate(20,2),48,0.0001);
        assertEquals(arrayTabulatedFunction2.interpolate(20,6),112,0.00001);
    }
}