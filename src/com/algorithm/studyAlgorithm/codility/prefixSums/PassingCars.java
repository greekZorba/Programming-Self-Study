package com.algorithm.studyAlgorithm.codility.prefixSums;

/**
 * Prefix Sums 문제
 *
 * */
public class PassingCars {

    public static void main(String[] args){
        int[] A = new int[]{0,1,0,1,1};
        System.out.println(solution(A));
    }

    private static int solution(int[] A){
        int travleEastCar = 0;
        int pairCarSum = 0;

        for(int i=0; i<A.length; i++){

            if(A[i] == 0){
                travleEastCar++;
            }else{
                pairCarSum += travleEastCar;
                if(pairCarSum > 1000000000){
                    pairCarSum = -1;
                    break;
                }
            }
        }

        return pairCarSum;
    }
}
