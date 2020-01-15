package com.algorithm.studyAlgorithm;

/**
 * 피보나치 수열
 * 1. 재귀방식을 이용한 피보나치 수열 구현
 * 2. 메모이제이션을 이용한 피보나치 수열 구현
 *
 * */
public class Fibonacci {

    public int recursionFibonacci(int input) {
        if(input == 0) {
            return 0;
        }

        if(input == 1) {
            return 1;
        }

        return recursionFibonacci(input-1) + recursionFibonacci(input-2);
    }

    public int memoizationFibonacci(int[] memorize, int input) {
        if(input == 0) {
            return 0;
        }

        if(input == 1) {
            return 1;
        }

        if(memorize[input] > 0) {
            return memorize[input];
        }

        memorize[input] = memoizationFibonacci(memorize,input-1) + memoizationFibonacci(memorize,input-2);

        return memorize[input];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int[] memorize = new int[10];
        System.out.println("재귀방식의 피보나치 구현 : "+fibonacci.recursionFibonacci(10));
        System.out.println("메모이제이션을 이용한 피보나치 구현 : "+fibonacci.memoizationFibonacci(memorize,7));
    }
}
