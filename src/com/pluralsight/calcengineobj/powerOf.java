package com.pluralsight.calcengineobj;

/**
 * Created by Elev12 on 2016-06-27.
 */
public class powerOf implements MathProcessing {

    @Override
    public String getKeyWord() {
        return "power";
    }

    @Override
    public char getSymbol() {
        return '^';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return Math.pow(leftVal, rightVal);
    }
}
