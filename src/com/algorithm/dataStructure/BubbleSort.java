package com.algorithm.dataStructure;

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
