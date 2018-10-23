package com.algorithm.studyAlgorithm;

import java.util.Arrays;

/********************************************************************
 *
 * 이진검색트리 알고리즘
 *
 * 왼쪽 노드는 루트보다 작고, 오른쪽 노드는 루트보다 큰 트리이다.
 * 찾고자 하는 값이 루트보다 작으면 왼쪽 노드로, 크면 오른쪽 노드로 탐색한다.
 *
 * 슈도 코드
 * 1. 재귀
 * BinarySearchTree(x, k) - x는 루트 노드, k는 찾는 값이다
 *  if x=NIL or k = key[x]
 *     then return x
 *
 *  if k<key[x]
 *     then return BinarySearchTree(left[x], k)
 *     else return BinarySearchTree(right[x], k)
 *
 * 2. 반복문
 *  IterateTreeSearch(x,k)
 *    while x != NIL and k != key[x]
 *      do if k<key[x]
 *          then x <= left[x]
 *          then x <= right[x]
 *
 *    return x
 *
 * 시간복잡도는 O(h)이다. 여기서 h는 트리의 높이다.
 * 최악의 경우 O(n)이다. 트리의 모양이 오른쪽 노드만 있어서 계속 값이 커지는 경우 노드를 끝까지 따라 내려가는 경우가 생긴다.
 *
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class BinarySearchTree {

    /** 배열의 0번째 순서가 아니라 숫자 1,2,3 순서라고 생각하고 결과 값 나오게 함 */
    private static int[] binaryTree;
    private static String result;
    public static void main(String[] args){
        result = "";
        binaryTree = new int[]{1,5,7,2,10,3,40,6,20,55,21,33};
        Arrays.sort(binaryTree); /** 이진검색트리로 만들어줌 */

        binarySearch(0, binaryTree.length-1, 5);
        System.out.println(result);
    }

    private static void binarySearch(int startIndex, int endIndex, int findingInt){
        int rootNodeIndex = (endIndex + startIndex)/2;

        if(rootNodeIndex == startIndex || findingInt == binaryTree[rootNodeIndex]){

             result = findingInt != binaryTree[rootNodeIndex]
                        ? "못찾겠다 꾀꼬리" : "숫자는 "+String.valueOf(rootNodeIndex+1)+"번째 순서에 있다";
             return;
        }

        if(findingInt > binaryTree[rootNodeIndex]){

            startIndex = rootNodeIndex;
            binarySearch(startIndex, endIndex, findingInt);

        }else{

            endIndex = rootNodeIndex;
            binarySearch(startIndex, endIndex, findingInt);
        }
    }
}
