package com.algorithm.studyAlgorithm;

public class Sort {

    private static int[] sortedArray;

    public void mergeSort(int[] inputArray, int startPoint, int endPoint) {

        if(startPoint < endPoint) {
            int half = (startPoint + endPoint) / 2;
            mergeSort(inputArray, startPoint, half);
            mergeSort(inputArray, half+1, endPoint);
            merge(inputArray, startPoint, endPoint, half);
        }
    }

    public void merge(int[] inputArray, int startPoint, int endPoint, int halfPoint){
        int leftPoint = startPoint;
        int rightPoint = halfPoint+1;
        int index = startPoint;

        while(leftPoint <= halfPoint && rightPoint <= endPoint) {
            if(inputArray[leftPoint] <= inputArray[rightPoint]) {
                sortedArray[index] = inputArray[leftPoint];
                leftPoint++;

            }else {
                sortedArray[index] = inputArray[rightPoint];
                rightPoint++;

            }

            index++;

        }

        while(leftPoint <= halfPoint) {
            sortedArray[index++] = inputArray[leftPoint++];
        }

        while(rightPoint <= endPoint) {
            sortedArray[index++] = inputArray[rightPoint++];
        }

        for(int i=startPoint; i<=endPoint; i++) {
            inputArray[i] = sortedArray[i];
        }
    }

    public void quickSort(int[] inputArray, int startPoint, int endPoint) {

        if(startPoint < endPoint) {
            int pivotPosition = getPivotPosition(inputArray, startPoint, endPoint);
            quickSort(inputArray, startPoint, pivotPosition-1);
            quickSort(inputArray, pivotPosition+1, endPoint);
        }


    }

    public int getPivotPosition(int[] inputArray, int startPoint, int endPoint) {
        int pivotPoint = endPoint;
        int smallerPivotPoint = startPoint-1;
        int biggerPivotPoint = startPoint;

        while(biggerPivotPoint <= endPoint) {

            if(inputArray[biggerPivotPoint] >= inputArray[pivotPoint]) {
                biggerPivotPoint++;
            }else {
                smallerPivotPoint++;
                swap(inputArray, smallerPivotPoint, biggerPivotPoint);
                biggerPivotPoint++;
            }
        }

        swap(inputArray, smallerPivotPoint+1, pivotPoint);

        return smallerPivotPoint+1;
    }

    public void heapSort(int[] inputArray, int heapSize) {

        // max Heap 성격을 가진 트리로 만들어준다.
        buildMaxHeap(inputArray, heapSize);

        for(int i=0; i<inputArray.length; i++) {
            swap(inputArray, 0, heapSize-1);
            heapSize--;
            maxHeapify(inputArray, 0, heapSize);
        }

    }

    public void buildMaxHeap(int[] inputArray, int heapSize) {

        for(int i=heapSize/2; i>=0; i--) {
            maxHeapify(inputArray, i, heapSize);
        }
    }

    public void maxHeapify(int[] inputArray, int root, int heapSize) {
        int rootIndex = root;
        int leftNode = 2*root+1;
        int rightNode = 2*root+2;

        while(leftNode < heapSize || rightNode < heapSize) {

            int biggestNode;
            if(rightNode >= heapSize
                    || inputArray[leftNode] > inputArray[rightNode]) {

                biggestNode = leftNode;
            } else{
                biggestNode = rightNode;
            }

            if(inputArray[rootIndex] < inputArray[biggestNode]) {
                swap(inputArray, rootIndex, biggestNode);

                rootIndex = biggestNode;
                leftNode = 2*rootIndex+1;
                rightNode = 2*rootIndex+2;

            }
            // 부모노드의 값이 왼쪽, 오른쪽 노드보다 큼
            else {
                break;
            }


        }
    }

    public void swap(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }

    public void radixSort(int[] inputArray, int range) {

        for(int i=0; i<range; i++) {
            countingArray(inputArray, i);
        }

    }

    public void countingArray(int[] inputArray, int digit) {
        int[] indexArray = new int[10];
        int[] sortedArray = new int[inputArray.length];

        for(int i=0; i<inputArray.length; i++) {
            indexArray[(inputArray[i]/(int)Math.pow(10, digit))%10]++;
        }

        for(int i=1; i<indexArray.length; i++) {
            indexArray[i] = indexArray[i] + indexArray[i-1];
        }

        for(int i=inputArray.length-1; i>=0; i--) {
            // 배열의 인덱스는 0부터 시작하므로 -1을 한다.
            sortedArray[indexArray[(inputArray[i]/(int)Math.pow(10, digit))%10]-1] = inputArray[i];
            indexArray[(inputArray[i]/(int)Math.pow(10, digit))%10]--;
        }

        for(int i=0; i<sortedArray.length; i++) {
            inputArray[i] = sortedArray[i];
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] inputArray = new int[]{3,5,7,1,3,2,6,8};
        sortedArray = new int[inputArray.length];
        sort.mergeSort(inputArray, 0, 7);
        System.out.print("merge sort : ");
        for(int i=0; i<sortedArray.length; i++){
            System.out.print(sortedArray[i] + " ");
        }

        System.out.println();
        inputArray = new int[]{3,5,7,1,3,8,6,2};
        sort.quickSort(inputArray, 0, 7);
        System.out.print("quick sort : ");
        for(int i=0; i<inputArray.length; i++) {
            System.out.print(inputArray[i]+ " ");
        }

        System.out.println();
        inputArray = new int[]{32,555,7,11,3,823,6,2};
        sort.radixSort(inputArray, 3);
        System.out.print("radix sort : ");
        for(int out : inputArray) {
            System.out.print(out + " ");
        }

    }
}
