package com.algorithm.studyAlgorithm.BinarySearchTree;

import java.util.Collections;
import java.util.LinkedList;

public class TreeInsert {

    private static LinkedList<Integer> binaryTree;
    private static String result;
    public static void main(String[] args){
        binaryTree = new LinkedList<>();
        binaryTree.add(8); binaryTree.add(5); binaryTree.add(7);
        binaryTree.add(2); binaryTree.add(10); binaryTree.add(3);
        binaryTree.add(40); binaryTree.add(6); binaryTree.add(20);
        binaryTree.add(55); binaryTree.add(21); binaryTree.add(33);
        Collections.sort(binaryTree); /** 이진검색트리로 만들어줌 */

        System.out.print("이진검색트리 배열 :");
        for(int out: binaryTree){
            System.out.print(out+" ");
        }
        System.out.println();

        int insertValue = 18;
        System.out.println("이진검색트리에 "+ insertValue + "을 삽입 !! ");

        insertIntoBinarySearchTree(binaryTree, insertValue);
    }

    private static void insertIntoBinarySearchTree(LinkedList<Integer> inputArray, int insertValue){
        /** 이진검색트리는 크기에 중간 값이 부모 노드가 되기 때문에 아래와 같은 방식으로 부모 노드를 구현*/
        int forwardNode = inputArray.size()/2;
        int startIndex = 0;

        /** 마지막 인덱스가 배열의 인덱스보다 1 커야 마지막 배열도 체크할 수 있다. */
        int endIndex = inputArray.size();

        while(forwardNode > startIndex){

            if(insertValue > inputArray.get(forwardNode)){

                startIndex = forwardNode;
                forwardNode = (startIndex+endIndex)/2;
            }else{

                endIndex=forwardNode;
                forwardNode = (startIndex+endIndex)/2;
            }
        }

        /** 삽입 값이 부모 노드보다 크다면 오른쪽 노드로 가게 만든다. */
        if(insertValue > inputArray.get(forwardNode)){
            forwardNode += 1;
        }
        /** 부모노드보다 삽입 값이 작다면 현재 부모 인덱스를 삽입하면 왼쪽 노드가 된다. */

        inputArray.add(forwardNode, insertValue);
        System.out.println(inputArray.toString());
    }


}
