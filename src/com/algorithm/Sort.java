package com.algorithm;

public class Sort {

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

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] inputArray = new int[]{0,4,1,3,14,16,9,10,2,8,7};
        int heapSize = 11;
        sort.heapSort(inputArray, heapSize);

        System.out.println("heap Sort : ");
        for(int out : inputArray) {
            System.out.print(out + " ");
        }


    }

}
