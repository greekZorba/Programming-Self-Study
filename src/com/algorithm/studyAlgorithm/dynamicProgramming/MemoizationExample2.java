package com.algorithm.studyAlgorithm.dynamicProgramming;

import java.util.Arrays;

/**
 * 이항계수를 이용해 Memoization을 구현하는 방법이다.
 * 이항계수란 주어진 크기의(순서 없는) 조합의 가짓수이다.
 *
 * nCk = (n) 즉, n개 중 k를 선택할 경우의 수이다.
 *       (k)
 *
 * (n) = { 1                if n=k or k=0
 * (k)   { (n-1) + (n-1)    otherwise
 *         ( k )   (k-1)    왜냐면 n에서 k를 제외하면 n-1 크기를 가진다. n-1에서 k를 선택할 경우와 안할 경우를 합하면
 *                          nCk의 경우의 수와 같다.
 *
 *  nCk를 구하는 공식: n!/(n-k)!k!
 * */
public class MemoizationExample2 {

    private int[][] rememberBinomial;

    /** 계산결과 값을 담아줄 배열의 초기화 */
    public MemoizationExample2(int n, int k){
        rememberBinomial = new int[n+1][k+1];

        for(int i=1; i<=n; i++){
            Arrays.fill(rememberBinomial[i], -1);
        }
    }

    private int memoizationBinomial(int n, int k){

        if(n == k || k == 0){
            return 1;
        }
        /** 이미 계산된 값을 중복 계산할 필요없이 반환한다. */
        else if(rememberBinomial[n][k] > -1){
            return rememberBinomial[n][k];
        }
        /** 계산결과를 기억하고 그 값을 반환한다. */
        else{
            rememberBinomial[n][k] = memoizationBinomial(n-1, k)+memoizationBinomial(n-1, k-1);
            return rememberBinomial[n][k];
        }
    }

    public static void main(String[] args){
        int n = 100;
        int k = 98;
        MemoizationExample2 memoization = new MemoizationExample2(n, k);
        System.out.println("Memoization을 활용해서 나온 이항계수 결과 값 : "+memoization.memoizationBinomial(n, k));
    }
}
