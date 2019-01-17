package com.algorithm.studyAlgorithm.codility;

public class MinAvgTwoSlice {

    public int solution(int[] A){

        int minIndex = 0;
        double min = Double.MAX_VALUE;
        for(int i=0; i<A.length-1; i++){
            int sum = A[i];


            for(int j=i+1; j<A.length; j++){
                sum += A[j];
                double avg = sum/(j-i+1.0);

                if(min > avg){
                    min = avg;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }


    public static void main(String[] args) {
        MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

        int[] A = new int[]{4,2,2,5,1,5,8};
        System.out.println(minAvgTwoSlice.solution(A));
    }
}
