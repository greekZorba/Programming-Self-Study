package com.algorithm.studyAlgorithm.sort;

/********************************************************************
 *
 *
 * 버블소트는 물방울이 올라오는 것 같아 지어진 이름.
 * 시간 복잡도는 O(n^2)
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class BubbleSort {

    public static void main(String[] args){
        int[] input = new int[]{29, 10, 14, 37, 13};

        for(int i=0; i<input.length; i++){
            for(int j=1; j<input.length-i; j++){

                if(input[j]<input[j-1]){
                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        for(int a: input){
            System.out.print(a+" ");
        }


    }
}
