package com.algorithm.studyAlgorithm.codility.sorting;

import java.util.LinkedHashSet;

public class Distinct {

    public int solution(int[] A){
        LinkedHashSet<Integer> distinctArray = new LinkedHashSet<>();
        for(int i =0; i<A.length; i++){
            distinctArray.add(A[i]);
        }

        return distinctArray.size();
    }


    public static void main(String[] args){
        int[] A = new int[]{2,1,1,2,3,1};
        Distinct distinct = new Distinct();
        System.out.println(distinct.solution(A));
    }
}
