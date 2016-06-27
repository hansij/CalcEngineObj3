package com.pluralsight.calcengineobj;

/**
 * Created by Elev12 on 2016-06-27.
 */
public interface MathProcessing {
    String SEPERATOR = " ";
    String getKeyWord(); // add
    char   getSymbol(); // +
    double doCalculation(double leftVal, double rightVal);
}
