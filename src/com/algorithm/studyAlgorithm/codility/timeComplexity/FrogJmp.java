package com.algorithm.studyAlgorithm.codility.timeComplexity;

/**
 * TimeComplexity 문제
 * 시간복잡도 : O(1)
 * */
public class FrogJmp {

    public static void main(String[] args){
        int X = 10;
        int Y = 85;
        int D = 30;
        System.out.println(solution(X, Y, D));
    }

    private static int solution(int X, int Y, int D){
        int jumpCount = 0;
        int distance = Y-X;
        if(distance%D != 0){
            jumpCount = distance/D + 1;
        }else{
            jumpCount = distance/D;
        }

        return jumpCount;
    }

}
