package com.algorithm.studyAlgorithm.codility.countingElements;

import java.util.*;

public class MaxCounters {

    public static void main(String[] args){
        int N = 5;
        int[] A = new int[]{3,4,4,6,1,4,4};
        int[] result = solution(N, A);

        for(int out: result){
            System.out.print(out + " ");
        }
    }

    private static int[] solution(int N, int[] A){
        int[] returnArray = new int[N];

        int beforeMax = 0;
        int updatedMax = 0;
        for(int i=0; i<A.length; i++){


            if(A[i]==N+1){
                updatedMax = beforeMax;
            }else{

                if(returnArray[A[i]-1]<updatedMax){
                    returnArray[A[i]-1] = updatedMax+1;
                }else{
                    returnArray[A[i]-1]++;
                }

                if(returnArray[A[i]-1]>beforeMax){
                    beforeMax = returnArray[A[i]-1];
                }

            }
        }

        for(int i=0; i<returnArray.length; i++){
            if(returnArray[i]<updatedMax){
                returnArray[i] = updatedMax;
            }
        }

        return  returnArray;
    }
}
