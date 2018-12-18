package com.algorithm.studyAlgorithm.dynamicProgramming;

import java.util.Arrays;

/**
 * Memoization이란 값을 기억해뒀다가 리턴해주는 방식으로 중복 계산을 피할 수 있도록 한다.
 * 동적 계획법의 한 종류이다.
 *
 * 예시는 피보나치 수열을 활용한 Memoization이다.
 * */
public class MemoizationExample1 {

    private int[] rememberFibonacci;

    /** 계산결과 값을 담아줄 배열의 초기화 */
    public MemoizationExample1(int n){
        rememberFibonacci = new int[n+1];
        Arrays.fill(rememberFibonacci, -1);
    }

    private int memoizationFibonacci(int n){

        if(n == 1 || n == 2){
            return 1;
        }
        /** 이미 계산된 값을 중복 계산할 필요없이 반환한다. */
        else if(rememberFibonacci[n] > -1){
            return rememberFibonacci[n];
        }
        /** 계산결과를 기억하고 그 값을 반환한다. */
        else{
            rememberFibonacci[n] = memoizationFibonacci(n-1)+memoizationFibonacci(n-2);
            return rememberFibonacci[n];
        }
    }

    public static void main(String[] args){

        int n = 10;
        MemoizationExample1 memoization = new MemoizationExample1(n);

        System.out.println("Memoization을 활용해서 나온 피보나치 결과 값 : "
                + memoization.memoizationFibonacci(n));
    }
}
