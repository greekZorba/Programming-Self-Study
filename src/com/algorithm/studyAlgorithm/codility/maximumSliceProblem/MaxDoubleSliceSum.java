package com.algorithm.studyAlgorithm.codility.maximumSliceProblem;

public class MaxDoubleSliceSum {

    public int solution(int[] A) {

        int maxEnding = 0;
        int maxSlice = 0;
        int excludeCount = 0;
        for(int i=1; i<A.length-1; i++){

            if(excludeCount == 3){
                excludeCount = 0;
                maxEnding = 0;
            }

            if(maxEnding > maxEnding+A[i]){
                excludeCount++;
            }

            maxEnding += A[i];

            maxSlice = Math.max(maxSlice, maxEnding);
        }

        return maxSlice;
    }

    public static void main(String[] args) {
        MaxDoubleSliceSum maxDoubleSliceSum = new MaxDoubleSliceSum();
        int[] A = new int[]{-3,5,-4,-5,20,-1,5,-6,-7};
        System.out.println(maxDoubleSliceSum.solution(A));
    }

}
