package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.io;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations.TabulatedDifferentialOperator;

import java.io.*;

import static ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.io.FunctionsIO.deserialize;

public class ArrayTabulatedFunctionSerialization {
    public static void main(String[] args) {
        try {
            double[] xValues = new double[]{1, 2, 3};
            double[] yValues = new double[]{1, 4, 9};
            ArrayTabulatedFunction arrayOrig = new ArrayTabulatedFunction(xValues, yValues);
            TabulatedFunction arrayFirstDif = new TabulatedDifferentialOperator().derive(arrayOrig);
            TabulatedFunction arraySecondDif = new TabulatedDifferentialOperator().derive(arrayFirstDif);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("output/serialized array functions.bin"));
            FunctionsIO.serialize(out, arrayOrig);
            FunctionsIO.serialize(out, arrayFirstDif);
            FunctionsIO.serialize(out, arraySecondDif);

            BufferedInputStream input = new BufferedInputStream(new FileInputStream("output/serialized array functions.bin"));
            TabulatedFunction origFunction = FunctionsIO.deserialize(input);
            System.out.println(origFunction.toString());
            TabulatedFunction firstFunction = FunctionsIO.deserialize(input);
            System.out.println(firstFunction.toString());
            TabulatedFunction secondFunction = FunctionsIO.deserialize(input);
            System.out.println(secondFunction.toString());
        } catch (IOException | ClassNotFoundException error) {
            error.printStackTrace();
        }
    }
}
