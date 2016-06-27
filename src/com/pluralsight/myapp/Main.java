package com.pluralsight.myapp;

import com.pluralsight.calcengineobj.CalculateBase;
import com.pluralsight.calcengineobj.CalculateHelper;
import com.pluralsight.calcengineobj.DynamicHelper;
import com.pluralsight.calcengineobj.InvalidStatementException;
import com.pluralsight.calcengineobj.MathEquation;
import com.pluralsight.calcengineobj.Adder;
import com.pluralsight.calcengineobj.Divider;
import com.pluralsight.calcengineobj.MathProcessing;
import com.pluralsight.calcengineobj.Multiplier;
import com.pluralsight.calcengineobj.Subtracter;
import com.pluralsight.calcengineobj.powerOf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //useFileReader();
        //useCalculateHelper();
        //useMethodExecute();
        useInteface();



    }

    static  void useInteface(){
        // uses MathProcessing.java
        //      DynamicHelper.java

        System.out.println();
        System.out.println("Using Interface");
        System.out.println();

        String[] statements = {
                "add 25.0 92.0",
                "power 5.0 2.0",
                "divide 100.0 50.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"

        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new powerOf(),
                new Divider(),
                new Subtracter(),
                new Multiplier()
        });

        for(String statement:statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }
    }

    static  void useFileReader(){
// Other
        BufferedReader reader = null;
        int total = 0;
        try {
            reader = new BufferedReader(new FileReader("C:\\Numbers.txt"));
            String line = null;
            while ((line = reader.readLine()) != null)
                total += Integer.valueOf(line);
            System.out.println("Total: " + total);
        } catch (NumberFormatException e) {
            System.out.println("Felaktigt värde: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Filfel: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Kan inte arbeta med fil: " + e.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
// End other
    }

static void useCalculateHelper() {
            System.out.println();
            System.out.println("Using String Method With Errorhandling");
            System.out.println();

            String[] statements = {
                    "add 1.0",
                    "add xx 25.0",
                    "addX 0.0 0.0",
                    "divide 100.0 50.0",
                    "add 25.0 92.0",
                    "subtract 225.0 17.0",
                    "multiply 11.0 3.0"
            };

            CalculateHelper helper = new CalculateHelper();
            for (String statement : statements) {
                try {
                    helper.process(statement);
                    System.out.println(helper);
                } catch (InvalidStatementException e) {
                    System.out.println(e.getMessage());
                    if (e.getCause() != null)
                        System.out.println(" Orginal exception: " + e.getCause().getMessage());
                }
            }
        }

        static void useMethodExecute() {
        System.out.println();
        System.out.println("Using Method execute()");
        System.out.println();

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }

        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for (CalculateBase calculator : calculators) {
            calculator.calculate();
            System.out.print("result = ");
            System.out.println(calculator.getResult());

        }
    }

}
