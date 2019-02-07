package com.algorithm.studyAlgorithm.codility.maximumSliceProblem;

public class MaxSliceSum {

    public int solution(int[] A) {
        int maxEnding = 0;
        int maxSlice = A[0];

        for(int i=0; i<A.length; i++){

            maxEnding += A[i];

            /** 음수 대응 */
            if(A[i] > maxEnding){
                maxEnding = A[i];
            }

            maxSlice = Math.max(maxSlice, maxEnding);
        }

        return maxSlice;
    }

    public static void main(String[] args) {
        MaxSliceSum maxSliceSum = new MaxSliceSum();
        int[] A = new int[]{-1000,4,5};
        System.out.println(maxSliceSum.solution(A));
    }
}
