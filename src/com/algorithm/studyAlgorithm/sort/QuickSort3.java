package com.algorithm.studyAlgorithm.sort;

/********************************************************************
 *
 *
 * QuickSort(빠른 정렬)
 * 비고: 피벗은 배열의 인덱스 중간 값으로 한다
 *
 * 출처: 엔지니어 대한민국 유튜브
 *
 *********************************************************************/
public class QuickSort3 {

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
        int dividedIndex = partition(inputArray, startPoint, endPoint); // 피벗보다 큰 수와 작은 수 범위를 나눠줄 인덱스
        if(startPoint < dividedIndex-1) {
            // 피벗의 왼쪽 부분 배열 정렬
            quickSort(inputArray, startPoint, dividedIndex-1);
        }
        if(dividedIndex < endPoint) {
            // 피벗의 오른쪽 부분 배열 정렬
            quickSort(inputArray, dividedIndex, endPoint);
        }
    }

    private static int partition(int[] inputArray, int startPoint, int endPoint){ // 피벗보다 작은 수와 큰 수를 나눠주는 메서드
        int pivot = inputArray[(startPoint+endPoint)/2];

        while(startPoint <= endPoint){ // 비교 대상이 피벗전까지만 비교함
            while(inputArray[startPoint] < pivot) startPoint++;
            while(inputArray[endPoint] > pivot) endPoint--;

            if(startPoint <= endPoint) {
                swap(inputArray, startPoint, endPoint);
                startPoint++;
                endPoint--;
            }
        }

        return startPoint; // 해당 인덱스를 기준으로 배열이 나눠져서 quicksort 수행

    }

    private static int[] swap(int[] inputArray, int firstIndex, int secondIndex){

        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;

        return inputArray;
    }


}
