package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.io;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        double[] xValues = new double[]{1, 2, 3};
        double[] yValues = new double[]{2, 4, 9};
        TabulatedFunction arrayFunction = new ArrayTabulatedFunction(xValues, yValues);
        TabulatedFunction listFunction = new LinkedListTabulatedFunction(xValues, yValues);
        try {
            BufferedWriter arrayBuffer = new BufferedWriter(new FileWriter("output/array function.txt"));
            BufferedWriter listBuffer = new BufferedWriter(new FileWriter("output/linked list function.txt"));
            FunctionsIO.writeTabulatedFunction(arrayBuffer, arrayFunction);
            FunctionsIO.writeTabulatedFunction(listBuffer, listFunction);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
