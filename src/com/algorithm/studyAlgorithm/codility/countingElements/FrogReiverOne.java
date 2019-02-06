package com.algorithm.studyAlgorithm.codility.countingElements;

import java.util.HashMap;
import java.util.Map;

public class FrogReiverOne {

    public static void main(String[] args){
        int X = 5;
        int[] A = new int[]{1,3,1,4,2,3,5,4};
        System.out.println(solution(X, A));
    }

    private static int solution(int X, int[] A){
        Map<String, Integer> leavesCheck = new HashMap<>();

        int seconds = -1;

        for(int i=0; i<A.length; i++){

            if(A[i] <= X && leavesCheck.get(String.valueOf(A[i])) == null){
                leavesCheck.put(String.valueOf(A[i]), A[i]);
            }

            if(leavesCheck.size() == X){
                seconds = i;
                break;
            }

        }

        return seconds;
    }
}
