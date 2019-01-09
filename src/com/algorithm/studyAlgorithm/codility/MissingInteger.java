package com.algorithm.studyAlgorithm.codility;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    public int solution(int[] A){
        Set<Integer> checkedNum = new HashSet<>();
        int min = 1;
        for(int i =0; i<A.length; i++){

            checkedNum.add(A[i]);

            if(min==A[i]){
                min++;
                while(checkedNum.contains(min)){
                    min++;
                }
            }

        }
        return min;
    }

    public static void main(String[] args){
        int[] A = new int[]{1,2,3};
        MissingInteger missingInteger = new MissingInteger();
        System.out.println(missingInteger.solution(A));
    }
}
