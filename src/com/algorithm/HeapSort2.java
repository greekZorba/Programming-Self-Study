package com.algorithm;

public class HeapSort2 {

    public void heapSort(int[] inputArray) {
        int size = inputArray.length;

        // 맥스 힙 속성을 지니게 만든다
        buildMapHeap(inputArray, size);

        // 맥스 힙이 되도록 만든다.
        int heapSize = inputArray.length;
        for(int i=0; i<size; i++) {
            swap(inputArray, 0, heapSize-1);
            maxHeapify(inputArray, 0, heapSize);
            heapSize--;
        }
    }

    public void buildMapHeap(int[] inputArray, int size) {

        for(int i=size/2; i>=0; i--) {
            maxHeapify(inputArray, i, size);
        }
    }

    public void maxHeapify(int[] inputArray, int rootIndex, int size) {
        int rootNode = rootIndex;
        int leftNode = 2*rootIndex+1;
        int rightNode = 2*rootIndex+2;

        while(leftNode < size && rightNode < size) {
            int biggestNode = inputArray[leftNode] > inputArray[rightNode] ? leftNode : rightNode;

            if(inputArray[rootNode] < inputArray[biggestNode]) {
                swap(inputArray, rootNode, biggestNode);

                rootNode = biggestNode;
                leftNode = 2*biggestNode+1;
                rightNode = 2*biggestNode+2;

            }
            // 힙 속성을 가졌음
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
        HeapSort2 heapSort = new HeapSort2();
        int[] inputArray = new int[]{6,7,2,5,2,7,8,9,20,45,2};
        System.out.println("정렬 전 힙 소트 : ");
        for(int out: inputArray) {
            System.out.print(out + " ");
        }

        heapSort.heapSort(inputArray);
        System.out.println();
        System.out.println("--------------------");
        System.out.println("정렬 후 힙 소트 : ");
        for(int out: inputArray) {
            System.out.print(out + " ");
        }

    }
}
