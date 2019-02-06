package com.algorithm.studyAlgorithm.codility.timeComplexity;

/**
 * TimeComplexity 문제
 *
 * */
public class TapeEquilibrium {

    public static void main(String[] args){
//        int[] A = new int[]{-10, -20, -30, -40, 100};
        int[] A = new int[]{-1000,1000,1000};
        System.out.println(solution(A));
    }

    private static int solution(int[] A){
        int originalSum = 0;
        for(int i=0; i<A.length; i++){
            originalSum += A[i];
        }

        int max = Integer.MAX_VALUE;
        int afterSum = 0;
        for(int i=0; i<A.length-1; i++){
            originalSum -= A[i];
            afterSum += A[i];

            if(max > Math.abs(afterSum-originalSum)){
                max = Math.abs(afterSum-originalSum);
            }
        }

        if(A.length == 2){
            max = Math.abs(A[0]-A[1]);
        }
        return max;
    }
}
