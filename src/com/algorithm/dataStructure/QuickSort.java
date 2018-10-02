package com.algorithm.dataStructure;

/********************************************************************
 *
 *
 * QuickSort(빠른 정렬)
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class QuickSort {

    private static int[] simpleArray;
    public static void main(String[] args){


    }

    private static quickSort(int[] inputArray, int startPoint, int endPoint){
        int dividedIndex = 0; // 피벗보다 큰 수와 작은 수 범위를 나눠줄 인덱스
        if(startPoint<endPoint){
            dividedIndex = partition(inputArray, startPoint, endPoint); // 분할을 수행함
            quickSort(inputArray, startPoint, dividedIndex-1); // 왼쪽 부분 배열 정렬
            quickSort(inputArray, startPoint+1, endPoint); // 오른쪽 부분 배열 정렬
        }
    }

    private int partitian(int[] inputArray, int startPoint, int endPoint){ // 피벗보다 작은 수와 큰 수를 나눠주는 메서드
        int pivot = inputArray[endPoint];
        int biggerPivotIndex = startPoint;
        int smallerPivotIndex = startPoint-1;
        while(biggerPivotIndex < endPoint){

            if(inputArray[biggerPivotIndex] >= pivot){
                biggerPivotIndex++;
            }else{
                smallerPivotIndex++;
                inputArray = swap(inputArray, smallerPivotIndex, biggerPivotIndex);
                biggerPivotIndex++;
            }
        }
    }

    private int[] swap(int[] inputArray, int firstIndex, int secondIndex){

        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;

        return inputArray;
    }


}
