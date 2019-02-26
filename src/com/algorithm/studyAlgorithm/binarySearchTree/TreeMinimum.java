package com.algorithm.studyAlgorithm.binarySearchTree;

import java.util.Arrays;

/********************************************************************
 *
 * 이진검색트리 트리 최소값 찾기
 *
 * 이진검색트리의 최소값은 가장 왼쪽 아래 노드이다.
 * 시간복잡도: O(h) 여기서 h는 높이
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class TreeMinimum {

    private static int[] binaryTree;
    private static String result;
    public static void main(String[] args){
        binaryTree = new int[]{1,5,7,2,10,3,40,6,20,55,21,33};
        Arrays.sort(binaryTree); /** 이진검색트리로 만들어줌 */
        System.out.print("이진검색트리 배열 :");
        for(int out: binaryTree){
            System.out.print(out+" ");
        }
        System.out.println();
        System.out.println("트리를 타고 가는 과정 --");

        /** 마지막 인덱스가 배열의 인덱스보다 1 커야 마지막 배열도 체크할 수 있다. */
        searchTreeMinimum(0, binaryTree.length);


    }

    private static void searchTreeMinimum(int startIndex, int endIndex){
        /** 이진검색트리는 크기에 중간 값이 부모 노드가 되기 때문에 아래와 같은 방식으로 부모 노드를 구현*/
        int parentNodeIndex = (startIndex + endIndex)/2;
        if(parentNodeIndex == startIndex){
            System.out.println("트리 중 가장 작은 수 : "+binaryTree[parentNodeIndex]);
            return;
        }

        System.out.println(binaryTree[parentNodeIndex]);
        searchTreeMinimum(startIndex, parentNodeIndex);

    }
}
