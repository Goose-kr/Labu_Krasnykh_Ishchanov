package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.io;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations.TabulatedDifferentialOperator;

import java.io.*;

public class LinkedListTabulatedFunctionSerialization {
    public static void main(String[] args){
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("output/serialized linked list functions.bin"))){
            final double[] xValues = {1.,2.,5.,8.,9.};
            final double[] yValues = {1.,4.,25.,64.,81.};
            final TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
            TabulatedFunction linkedListOrig = new LinkedListTabulatedFunction(xValues,yValues);
            TabulatedFunction linkedListFirstDif = operator.derive(linkedListOrig);
            TabulatedFunction linkedListSecondDif = operator.derive(linkedListFirstDif);
            FunctionsIO.serialize(out, linkedListOrig);
            FunctionsIO.serialize(out, linkedListFirstDif);
            FunctionsIO.serialize(out,linkedListSecondDif);
            out.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("output/serialized linked list function.bin"))){
            TabulatedFunction linkedListSecondDif = FunctionsIO.deserialize(in);
            TabulatedFunction linkedListFirstDif = FunctionsIO.deserialize(in);
            TabulatedFunction linkedListOrig = FunctionsIO.deserialize(in);
            in.close();
            linkedListOrig.toString();
            linkedListFirstDif.toString();
            linkedListSecondDif.toString();
        }
        catch (IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
