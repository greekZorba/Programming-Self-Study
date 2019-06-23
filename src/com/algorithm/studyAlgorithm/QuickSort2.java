package com.algorithm.studyAlgorithm;

public class QuickSort2 {

    public void quickSort(int[] inputArray, int startPoint, int endPoint) {

        if(startPoint < endPoint) {
            int dividedPoint = partition(inputArray, startPoint, endPoint);
            quickSort(inputArray, startPoint, dividedPoint-1);
            quickSort(inputArray, dividedPoint+1, endPoint);
        }
    }

    public int partition(int[] inputArray, int startPoint, int endPoint) {
        int minIndex = startPoint-1;
        int maxIndex = startPoint;

        while(maxIndex < endPoint) {

            if(inputArray[maxIndex] > inputArray[endPoint]) {
                maxIndex++;
            }else {
                minIndex++;
                swap(inputArray, minIndex, maxIndex);
                maxIndex++;
            }
        }
        swap(inputArray, minIndex+1, endPoint);

        return minIndex+1;
    }

    public void swap(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }

    public static void main(String[] args) {
        QuickSort2 quickSort = new QuickSort2();
        int[] inputArray = new int[]{1,2,7,3,2,4,6,7,10,32,12,53,21,40};
        quickSort.quickSort(inputArray, 0, inputArray.length-1);

        System.out.println("quick sort : ");
        for(int out : inputArray) {
            System.out.print(out + " ");
        }
    }
}
