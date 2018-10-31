package com.algorithm.studyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/********************************************************************
 *
 *
 * 힙을 이용해서 최대 우선 순위 큐(Maximum Priority Queue)
 * 배열에 든 값들 중 가장 큰 값이 먼저 나오고 추가되는 값은 마지막 자식노드 자리에 들어가는 알고리즘
 *
 * 원리
 * 1. 최대 힙 성격을 지닌 배열은 루트가 가장 큰 값이다.(최대 힙 property를 만족하는 트리의 루트는 자식노드보다 값이 크다)
 * 2. 값을 집어넣을 때는 배열의 마지막(마지막 자식 노드 자리)에 들어간다.
 *
 * 그래서 이러한 성격들이 '큐'와 같다. First In, First out
 * 꼭대기층의 부모노드가 첫번째 값이고 새로운 값이 가장 마지막 노드에 들어가기 때문이다.
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class MaximumPriorityQueue {

    static List<Integer> maximumPriorityQueue;
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        maximumPriorityQueue = new ArrayList<>(); // 처음 0은 인덱스를 1부터 시작하기 위한 더미 데이터
        maximumPriorityQueue.add(0); maximumPriorityQueue.add(2); maximumPriorityQueue.add(5);
        maximumPriorityQueue.add(8); maximumPriorityQueue.add(6); maximumPriorityQueue.add(13);
        maximumPriorityQueue.add(14); maximumPriorityQueue.add(7); maximumPriorityQueue.add(10);
        maximumPriorityQueue.add(15); maximumPriorityQueue.add(20);
        sb.append("초기 입력 배열 :"+maximumPriorityQueue.toString()+"\n");
        sb.append("---------------------------------------------- \n");

        buildMaxHeap(maximumPriorityQueue); // 최대 힙 성격을 지닌 배열
        sb.append("max heapify 수행 후 배열 :"+maximumPriorityQueue.toString()+"\n");
        sb.append("---------------------------------------------- \n");

        maxHeapInsert(maximumPriorityQueue, 17); // 최대 우선 순위 큐 삽입
        sb.append("힙 배열에 새로운 17 값을 넣어준 후 정렬된 배열 : "+maximumPriorityQueue.toString()+"\n");
        sb.append("---------------------------------------------- \n");

        sb.append("힙 배열에서 가장 큰 값을 뽑아냄(최대 우선 순위 큐) : "+heapExtractMax(maximumPriorityQueue)+"\n");
        sb.append("---------------------------------------------- \n");

        sb.append("최대 우선 순위 큐로 값을 뽑아낸 후의 배열 : "+maximumPriorityQueue.toString());
        System.out.print(sb.toString());
    }

    private static void buildMaxHeap(List<Integer> inputArray){
        if(inputArray == null || inputArray.size()-1 < 2){ // 배열이 널이거나 노드가 1개뿐일 경우,
            return;
        }

        int heapSize = inputArray.size()-1;
        for(int i=heapSize/2; i>=1; i--){ // 마지막 리프노드의 부모 루트를 시작으로 힙을 완성한다.
            maxHeapify(inputArray, i);
        }
    }

    private static void maxHeapify(List<Integer> inputArray, int rootIndex){
        int heapSize = inputArray.size()-1;

        int root = rootIndex;
        int leftNode = rootIndex*2;
        int rightNode = rootIndex*2+1;

        while(leftNode <= heapSize || rightNode <= heapSize){ // 자식이 있으면 반복

            if((leftNode <= heapSize && inputArray.get(root) >= inputArray.get(leftNode))
                    && (rightNode <= heapSize && inputArray.get(root) >= inputArray.get(rightNode))){ // 힙 속성 만족(부모가 자식 노드 값보다 큼)
                return;
            }

            /* 자식 노드 중 큰 값을 구하기 위한 연산 */
            int biggestNode = 0;
            if(rightNode > heapSize){ //오른쪽 노드가 없을 경우 왼쪽 노드가 비교 대상이 된다
                biggestNode = leftNode;
            }else{
                if(inputArray.get(leftNode) > inputArray.get(rightNode)){ // 자식 노드 중 왼쪽 노드가 클 경우
                    biggestNode = leftNode;
                }else{ // 자식 노드 중 오른쪽 노드가 클 경우
                    biggestNode = rightNode;
                }
            }

            /* 값이 큰 자식이 부모 값보다 크다면 swap */
            if(inputArray.get(root) < inputArray.get(biggestNode)){
                int temp = inputArray.get(root);
                inputArray.set(root, inputArray.get(biggestNode));
                inputArray.set(biggestNode, temp);

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

    /** 시간복잡도 O(log2) */
    private static void maxHeapInsert(List<Integer> inputArray, int insertValue){
        inputArray.add(insertValue); // 마지막 노드자리에 새로운 값 삽입
        int lastValueIndex = inputArray.size()-1; // 새로 들어온 값의 인덱스
        int parentIndex = lastValueIndex/2; // 노드의 부모 인덱스

        /* max 힙과 완전이진트리라는 가정 하에 다른 노드는 고려할 필요없이 새로운 값과 부모 노드의 값만 비교 하면 됨 */
        while(lastValueIndex > 1 && inputArray.get(parentIndex) < inputArray.get(lastValueIndex)){

            /* swap */
            int temp = inputArray.get(lastValueIndex);
            inputArray.set(lastValueIndex, inputArray.get(parentIndex));
            inputArray.set(parentIndex, temp);

            lastValueIndex = parentIndex; // 부모 노드가 시작점으로 됨
            parentIndex = parentIndex/2; // 부모 노드가 자식노드가 되면서 다시 부모노드를 설정
        }

    }

    /** 시간복잡도 O(log2) */
    private static int heapExtractMax(List<Integer> inputArray){
        if(inputArray.size() < 2){
            return -1;
        }

        int max = inputArray.get(1);
        /* 큐와 같이 값을 뽑으면 삭제 - 실제로는 기존 값을 덮게 만들고 마지막 노드 값을 삭제함
        *  루트 값이 삭제되면 마지막 노드를 가장 상위의 루트에 값을 넣어줌
        * */
        inputArray.set(1, inputArray.get(inputArray.size()-1));
        inputArray.remove(inputArray.size()-1);

        /** 마지막 노드가 루트로 갔으므로 다시 힙 속성을 맞춰준다 */
        maxHeapify(inputArray, 1);

        return max;
    }
}
