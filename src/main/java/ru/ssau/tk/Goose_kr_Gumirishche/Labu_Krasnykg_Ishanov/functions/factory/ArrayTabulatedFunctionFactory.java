package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;


public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory{

TabulatedFunction create(double[]xValues, double[]yValues){
           ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xValues,yValues);
            return arrayTabuletedFunction;
            }

            }
