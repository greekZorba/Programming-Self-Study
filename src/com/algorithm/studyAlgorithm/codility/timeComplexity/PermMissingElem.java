package com.algorithm.studyAlgorithm.codility.timeComplexity;

/**
 * TimeComplexity 문제
 *
 * */
public class PermMissingElem {

    public static void main(String[] args){
        int[] A = new int[]{2,3,1,5};
        System.out.println(solution(A));
    }

    private static int solution(int[] A){
        int[] countArray = new int[A.length+2];
        for(int i=0; i<A.length; i++){
            countArray[A[i]]++;
        }

        int result = 0;
        for(int i=1; i<countArray.length; i++){
            if(countArray[i] == 0){
                result = i;
            }
        }

        return result;
    }
}
