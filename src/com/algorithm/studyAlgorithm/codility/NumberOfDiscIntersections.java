package com.algorithm.studyAlgorithm.codility;

public class NumberOfDiscIntersections {

    public int solution(int[] A) {
        int numberOfIntersection = 0;
        for(int i=0; i<A.length-1; i++){
            long maxRange = i+A[i];
            for(int j=i+1; j<A.length; j++){

                if(j-A[j] <= maxRange && maxRange <= (long)j+A[j]
                || (long)j+A[j] <= maxRange){
                    numberOfIntersection++;

                    if(numberOfIntersection > 10000000){
                        return -1;
                    }
                }

            }
        }
        return numberOfIntersection;
    }

    public static void main(String[] args) {
        NumberOfDiscIntersections numberOfDiscIntersections = new NumberOfDiscIntersections();
        int[] A = new int[]{1,5,2,1,4,2147483647};
        System.out.println(numberOfDiscIntersections.solution(A));
    }
}
