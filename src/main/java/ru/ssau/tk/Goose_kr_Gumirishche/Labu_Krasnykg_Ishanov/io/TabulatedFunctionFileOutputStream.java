package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.io;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.LinkedListTabulatedFunctionFactory;

import java.io.*;

public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args) {
        try (BufferedOutputStream listOut = new BufferedOutputStream(new FileOutputStream("output/linked list function.bin"));
             BufferedOutputStream arrayOut = new BufferedOutputStream(new FileOutputStream("output/array function.bin"))){
            double[] xValues = new double[]{4.,5.,12.,14.,16.,20.};
            double[] yValues = new double[]{16.,25.,144.,196.,256.,400.};
            ArrayTabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
            LinkedListTabulatedFunctionFactory linkedListTabulatedFunctionFactory = new LinkedListTabulatedFunctionFactory();
            TabulatedFunction arrayFunction = arrayFactory.create(xValues,yValues);
            TabulatedFunction linkedListTabulatedFunction = linkedListTabulatedFunctionFactory.create(xValues,yValues);
            FunctionsIO.writeTabulatedFunction(arrayOut, arrayFunction);
            FunctionsIO.writeTabulatedFunction(listOut, linkedListTabulatedFunction);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
