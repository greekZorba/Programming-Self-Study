package com.algorithm.studyAlgorithm.sort;

/**
 *
 * 원리 :
 * 1. 가장 큰 수를 찾아서 맨 끝으로 보낸다.
 * 2. 가장 큰 수가 맨 끝으로 갔으므로 다음 비교하는 배열의 마지막 인덱스는 (기존 배열 길이의 - 1)로 가정한다.
 * 3. 그럼 처음부터 다시 가장 큰 수(이전 단계의 가장 큰 수 제외)를 찾아서 현재 배열의 마지막 인덱스로 보낸다.
 *
 * 예)
 * 1. { 9, 4, 10, 2, 1 } -> 가장 큰 수는 10이므로 마지막 인덱스와 swap
 * 2. { 9, 4, 1, 2, 10 } -> 1번의 연산으로 왼쪽처럼 배열이 되고, 다음 연산에서는 '10'이 들어간 인덱스는 제외하고 연산
 * 3. { 9, 4, 1, 2 (10 제외)} -> '2'가 있는 자리가 마지막 인덱스라고 가정하고 계산하는 것임
 * */
public class SelectionSort {

    public void sorting(int[] inputArray) {
        int arrayLength = inputArray.length;
        if(arrayLength <= 1) {
            return;
        }

        for(int i=0; i<arrayLength; i++) {
            int max = inputArray[0];
            int maxIndex = 0;

            for(int j=0; j<arrayLength-i; j++) {
                if(max < inputArray[j]) {
                    max = inputArray[j];
                    maxIndex = j;
                }
            }

            swap(inputArray, maxIndex, arrayLength-i-1);
        }

    }

    public void swap(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] inputArray = new int[]{5, 2, 6, 1, 3, 8, 4};

        selectionSort.sorting(inputArray);

        for(int out : inputArray) {
            System.out.print(out + " ");
        }


    }
}
