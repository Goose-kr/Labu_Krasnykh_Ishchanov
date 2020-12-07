package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.io;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations.TabulatedDifferentialOperator;

import java.io.*;

public class LinkedListTabulatedFunctionSerialization {
    public static void main(String[] args) {
        try {
            double[] xValues = new double[]{1, 2, 3};
            double[] yValues = new double[]{1, 4, 9};
            LinkedListTabulatedFunction list = new LinkedListTabulatedFunction(xValues, yValues);
            TabulatedFunction first = new TabulatedDifferentialOperator().derive(list);
            TabulatedFunction second = new TabulatedDifferentialOperator().derive(first);
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("output/serialized linked list functions.bin"));
            FunctionsIO.serialize(outputStream, list);
            FunctionsIO.serialize(outputStream, first);
            FunctionsIO.serialize(outputStream, second);

            BufferedInputStream input = new BufferedInputStream(new FileInputStream("output/serialized array functions.bin"));
            TabulatedFunction origFunction = FunctionsIO.deserialize(input);
            System.out.println(origFunction.toString());
            TabulatedFunction firstFunction = FunctionsIO.deserialize(input);
            System.out.println(firstFunction.toString());
            TabulatedFunction secondFunction = FunctionsIO.deserialize(input);
            System.out.println(secondFunction.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
