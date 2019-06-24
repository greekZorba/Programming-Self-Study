package com.algorithm.studyAlgorithm;

/********************************************************************
 *
 *
 * 힙을 만드는 알고리즘(힙 정렬이 아닌 힙)+ 힙 정렬 - 여기서 기준은 max이다. (루트가 자식 노드보다 크거나 같다)
 *
 * complete binary tree + heap property를 만족하는 트리 만들기
 * complete binary tree는 마지막 레벨을 제외하고 모든 노드가 채워져있고, 마지막 레벨에서는
 * 왼쪽은 채워져있어야 한다. (오른쪽은 채워져있고 왼쪽 노드가 없으면 조건 성립 안됨)
 *
 * heap property는 여기서 루트가 자식 노드 값보다 크거나 같아야 한다.(max heap property)
 * 하지만, min heap property라면 루트가 자식 노드 값보다 작거나 같아야 한다.
 *
 * 일차원 배열로 만들면 루트와 자식 노드들 사이의 인덱스는 아래와 같은 식이 성립한다.
 * root = index;
 * leftNode = index*2;
 * rightNode = index*2+1;
 *
 * 시간 복잡도는 O(nlogn)
 *
 * +++ 힙 정렬 추가 설명
 *
 * 힙을 구성한다면 root는 모든 노드 중에서 가장 큰 값이 된다.
 * root를 마지막 인덱스와 swap하고 힙 사이즈를 하나 줄여서
 * 다시 heapify를 수행한다.
 * 결과적으로 오름차순으로 정렬한다.
 *
 * (가장 큰 값이 배열 맨 뒤로 가고 남은 배열끼리 힙을 구성하면
 *  계속해서 가장 큰 값이 힙 맨 마지막으로 가기 때문에 결과적으로 오름차순이 됨)
 *
 *
 * 코드는 셀프로 작성했기 때문에 잘못된 부분이 있다면 피드백 부탁드립니다!
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class HeapSort {

    static int[] heapArray;
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        heapArray = new int[]{0,4,1,3,14,16,9,10,2,8,7}; // 0번째 배열은 index를 맞추기 위해 0을 임의로 넣음
        int heapSize = heapArray.length-1;

        sb.append("힙 정렬 전 배열 : ");
        for(int i = 1; i<heapArray.length; i++){
            sb.append(heapArray[i] + " ");
        }
        sb.append("\n");
        sb.append("------------------------------- \n");

        buildMaxHeap(heapArray);

        /* 힙 정렬 수행 */
        for(int i= heapArray.length-1; i>=2; i--){ // 노드가 2개 남을 때까지만 수행하면 됨, 마지막 1개는 의미 없음
            int temp = heapArray[1];
            heapArray[1] = heapArray[i];
            heapArray[i] = temp;
            heapSize = heapSize - 1;
            maxHeapify(heapArray, heapSize, 1);
        }

        sb.append("힙 정렬된 배열 : ");
        for(int i=1; i<heapArray.length; i++){
            sb.append(heapArray[i] + " ");
        }
        System.out.print(sb.toString());
    }

    private static void buildMaxHeap(int[] inputArray){
        if(inputArray == null || inputArray.length-1 < 2){ // 배열이 널이거나 노드가 1개뿐일 경우,
            return;
        }

        int heapSize = inputArray.length-1;
        for(int i=heapSize/2; i>=1; i--){ // 마지막 리프노드의 부모 루트를 시작으로 힙을 완성한다.
            maxHeapify(inputArray, heapSize, i);
        }
    }

    private static void maxHeapify(int[] inputArray, int heapSize, int rootIndex){
        int root = rootIndex;
        int leftNode = rootIndex*2;
        int rightNode = rootIndex*2+1;

        while(leftNode <= heapSize || rightNode <= heapSize){ // 자식이 있으면 반복

            if((leftNode <= heapSize && inputArray[root] >= inputArray[leftNode])
                    && (rightNode <= heapSize && inputArray[root] >= inputArray[rightNode])){ // 힙 속성 만족(부모가 자식 노드 값보다 큼)
                return;
            }

            /* 자식 노드 중 큰 값을 구하기 위한 연산 */
            int biggestNode = 0;
            if(rightNode > heapSize){ //오른쪽 노드가 없을 경우 왼쪽 노드가 비교 대상이 된다
                biggestNode = leftNode;
            }else{
                if(inputArray[leftNode] > inputArray[rightNode]){ // 자식 노드 중 왼쪽 노드가 클 경우
                    biggestNode = leftNode;
                }else{ // 자식 노드 중 오른쪽 노드가 클 경우
                    biggestNode = rightNode;
                }
            }

            /* 값이 큰 자식이 부모 값보다 크다면 swap */
            if(inputArray[root] < inputArray[biggestNode]){
                int temp = inputArray[root];
                inputArray[root] = inputArray[biggestNode];
                inputArray[biggestNode] = temp;

                /* 기존 부모 노드가 값이 큰 자식 노드로 내려가서 힙 속성 만족을 위해 다시 자식 노드를 체크해야함 */
                rootIndex = biggestNode;
            }else{
                return;
            }


            /* 바뀐 루트와 노드 값으로 인해 힙 속성 유지를 위해 자식 노드까지 내려 감 */
            root = rootIndex;
            leftNode = rootIndex*2;
            rightNode = rootIndex*2+1;
        }
    }

}
