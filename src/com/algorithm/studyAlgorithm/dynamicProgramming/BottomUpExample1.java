package com.algorithm.studyAlgorithm.dynamicProgramming;

/**
 * BottomUp 방식이란 동적계획법의 계산을 밑바닥부터 수행한다.
 * 아래서부터 계산하므로 결과값이 나오면 곧바로 return하므로 중복계산을 피할 수 있다.
 *
 * 예시는 피보나치 수열을 활용한 BottomUp 방식이다.
 * */
public class BottomUpExample1 {

    private int[] rememberFibonacci;

    public BottomUpExample1(int n){
        rememberFibonacci = new int[n+1];
    }

    private int bottomUpFibonacci(int n){

        if(n == 1 || n == 2){
            return 1;
        }
        else{
            rememberFibonacci[1] = 1;
            rememberFibonacci[2] = 1;

            for(int i=3; i<=n; i++){
                rememberFibonacci[i] = rememberFibonacci[i-1] + rememberFibonacci[i-2];
            }
        }

        return rememberFibonacci[n];
    }

    public static void main(String[] args){
        int n = 40;
        BottomUpExample1 bottomUp = new BottomUpExample1(n);
        System.out.println("BottomUp을 활용해서 나온 피보나치 결과 값 : "+bottomUp.bottomUpFibonacci(n));
    }
}
