package com.algorithm.studyAlgorithm;

public class Factorial {

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println("factorial 결과값 : "+ factorial.factorial(5));

    }

    public int factorial(int input) {
        if(input <= 1) {
            return 1;
        }

        return input * factorial(input-1);
    }
}
