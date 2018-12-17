package com.algorithm.studyAlgorithm.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Arrays 문제
 *
 * */
public class OddOccurrencesInArray {

    public static void main(String[] args){
        int[] A = new int[]{9,3,9,3,9,7,9};
        System.out.println(solution(A));
    }

    private static int solution(int[] A){
        Map<Integer, Integer> mapArray = new HashMap<>();

        for(int i=0; i<A.length; i++){

            if(mapArray.containsKey(A[i])){
                mapArray.put(A[i], mapArray.get(A[i])+1);
            }else{
                mapArray.put(A[i], 1);
            }

        }

        int result = 0;
        for(int i=0; i<A.length; i++){

            if(mapArray.get(A[i])%2 != 0){
                result = A[i];
                break;
            }
        }

        return result;
    }
}
