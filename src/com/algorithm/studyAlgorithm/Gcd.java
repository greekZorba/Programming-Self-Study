package com.algorithm.studyAlgorithm;


public class Gcd {

    public static void main(String[] args) {
        Gcd gcd = new Gcd();
        int a = 16;
        int b = 12;

        int gcdResult = gcd.gcdFunction(a, b);
        System.out.println("최대공약수 : "+ gcdResult);
        System.out.println("최소공배수 : "+(a * b / gcdResult));
    }

    public int gcdFunction(int a, int b) {
        if (a % b == 0)
            return b;
        return gcdFunction(b, a % b);
    }


}
