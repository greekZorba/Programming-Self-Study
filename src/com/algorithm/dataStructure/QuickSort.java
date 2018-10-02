package com.algorithm.dataStructure;

/********************************************************************
 *
 *
 * QuickSort(빠른 정렬)
 * 비고: 피벗은 배열의 마지막 값으로 가정함
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class QuickSort {

    private static int[] simpleArray;
    public static void main(String[] args){
        //simpleArray = new int[]{31, 8, 48, 73, 11, 3, 20, 29, 65, 15};
        simpleArray = new int[]{100, 8, 420, 20, 16, 89, 1020, 29, 50, 3};
        System.out.print("퀵소트로 정렬되기 전의 배열: ");
        for(int output: simpleArray){
            System.out.print(output+" ");
        }

        quickSort(simpleArray, 0, 9);

        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.print("퀵소트로 정렬이 끝난 배열: ");
        for(int output: simpleArray){
            System.out.print(output+" ");
        }

    }

    private static void quickSort(int[] inputArray, int startPoint, int endPoint){
        int dividedIndex = 0; // 피벗보다 큰 수와 작은 수 범위를 나눠줄 인덱스
        if(startPoint<endPoint){
            dividedIndex = partition(inputArray, startPoint, endPoint); // 분할을 수행함
            quickSort(inputArray, startPoint, dividedIndex-1); // 왼쪽 부분 배열 정렬
            quickSort(inputArray, dividedIndex+1, endPoint); // 오른쪽 부분 배열 정렬
        }
    }

    private static int partition(int[] inputArray, int startPoint, int endPoint){ // 피벗보다 작은 수와 큰 수를 나눠주는 메서드
        int pivot = inputArray[endPoint];
        int biggerPivotIndex = startPoint; // 피벗보다 큰 수가 될 인덱스이자 비교 대상

        /* 피벗보다 작은 수가 될 인덱스이자 비교 대상, 시작점보다 -1로 시작하는 것은 피벗보다 큰 수를 먼저 비교하고자 함이다*/
        int smallerPivotIndex = startPoint-1;
        while(biggerPivotIndex < endPoint){ // 비교 대상이 피벗전까지만 비교함

            if(inputArray[biggerPivotIndex] >= pivot){
                biggerPivotIndex++;
            }else{
                smallerPivotIndex++;
                inputArray = swap(inputArray, smallerPivotIndex, biggerPivotIndex);
                biggerPivotIndex++;
            }
        }
        /* 교환이 모두 끝나면 피벗보다 작은 수의 인덱스+1 자리에 피벗이 들어간다
        *  피벗보다 작은 수의 인덱스+1은 피벗보다 큰 수의 인덱스에 해당하기 때문에 분할이 제대로 이루어진다.
        * */
        swap(inputArray, smallerPivotIndex+1, endPoint);

        return smallerPivotIndex+1; // 피벗이 들어갈 자리

    }

    private static int[] swap(int[] inputArray, int firstIndex, int secondIndex){

        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;

        return inputArray;
    }


}
