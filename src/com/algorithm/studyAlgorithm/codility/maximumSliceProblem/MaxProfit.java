package com.algorithm.studyAlgorithm.codility.maximumSliceProblem;

public class MaxProfit {

    public int solution(int[] A) {
        if(A.length < 2){
            return 0;
        }

        int max = A[A.length-1];
        int diffNumber;
        int maxProfit = 0;
        for(int i=A.length-2; i>=0; i--){

            diffNumber = max - A[i];

            if(max < A[i]){
                max = A[i];
            }

            maxProfit = Math.max(maxProfit, diffNumber);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] A = new int[]{4,10,3,15,2,14,12};
        System.out.println(maxProfit.solution(A));
    }
}
